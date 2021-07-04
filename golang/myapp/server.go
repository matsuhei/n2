package main

import (
	"encoding/json"
	"net/http"

	"github.com/labstack/echo/v4"
	"github.com/labstack/echo/v4/middleware"
	"gorm.io/driver/postgres"
	"gorm.io/gorm"
)

type JSON json.RawMessage

func main() {
	e := echo.New()

	// Root level middleware
	e.Use(middleware.Logger())
	e.Use(middleware.Recover())

	e.GET("/", func(c echo.Context) error {
		return c.String(http.StatusOK, "Hello, World!")
	})

	e.GET("/users", getUsers)
	e.GET("/users/:id", getUser)
	e.POST("/users", saveUser)
	e.PUT("/users/:id", putUser)
	e.DELETE("users/:id", deleteUser)
	e.Logger.Fatal(e.Start(":1323"))
}

type User struct {
	gorm.Model
	Name string `json:"name"`
	Age  int    `json:"age"`
}

type UsersResponse struct {
	List []User `json:"list"`
}

// e.GET("/users/:id", getUser)
func getUser(c echo.Context) error {
	// User ID from path `users/:id`
	id := c.Param("id")

	var user User

	db := getDb()
	// Select
	db.Model(&User{}).First(&user, id)

	c.Logger().Printf("name: %v", user.Name)

	return c.String(http.StatusOK, "id: "+id+", user: "+user.Name)
}

func getUsers(c echo.Context) error {
	var users []User

	db := getDb()
	// Select
	db.Model(&User{}).Find(&users)

	return c.JSON(http.StatusOK, UsersResponse{List: users})
}

// e.POST("/users", saveUser)
func saveUser(c echo.Context) error {
	// Get name and age
	u := new(User)

	if err := c.Bind(u); err != nil {
		return echo.NewHTTPError(http.StatusBadRequest, err.Error())
	}

	user := User{Name: u.Name, Age: u.Age}

	db := getDb()
	// Create
	db.Model(&User{}).Create(&user)

	return c.String(http.StatusCreated, "name:"+u.Name+", age:"+string(u.Age))
}

// e.PUT("/users/:id", putUser)
func putUser(c echo.Context) error {
	// User ID from path `users/:id`
	id := c.Param("id")

	// Get name and age
	u := new(User)

	if err := c.Bind(u); err != nil {
		return echo.NewHTTPError(http.StatusBadRequest, err.Error())
	}

	db := getDb()
	// Updates
	db.Model(&User{}).Where("id = ?", id).Updates(u)

	return c.String(http.StatusOK, "name:"+u.Name+", age:"+string(u.Age))
}

// e.DELETE("/users/:id", deleteUser)
func deleteUser(c echo.Context) error {
	// User ID from path `users/:id`
	id := c.Param("id")

	db := getDb()
	// Delete
	db.Delete(&User{}, id)

	return c.NoContent(http.StatusNoContent)
}

// db設定取得
func getDb() *gorm.DB {
	dsn := "host=localhost user=root password=password dbname=testdb port=5555 sslmode=disable TimeZone=Asia/Tokyo"
	db, err := gorm.Open(postgres.Open(dsn), &gorm.Config{})
	if err != nil {
		panic("failed to connect database")
	}
	return db
}
