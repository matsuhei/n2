/**
 * 生成するインスタンスの数を1つに制限するデザインパターン
 *   指定したクラスのインスタンスが1つしか存在しないこと
 *   インスタンスが1個しか存在しないことをプログラム上で表現
 */

const singleton = (() => {

  var instance;

  function init() {
    function privateMethod() {
      console.log("private method");
    }

    var privateVariable = "private value";
    var privateRandomNumber = Math.random();

    return {
      publicMethod: () => {
        console.log("public method");
      },
      publicProperty: "public value",
      getRandomNumber: () => {
        return privateRandomNumber;
      }
    };
  };

  return {
    getInstance: () => {
      if (!instance) {
        instance = init();
      }
      return instance;
    }
  };

})();

module.exports = singleton.getInstance();
