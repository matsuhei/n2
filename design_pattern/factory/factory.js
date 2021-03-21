/**
 * インスタンスの作り方をスーパークラスで定め、具体的な処理をサブクラスで行うパターン
 *   オブジェクトの生成がFactoryメソッドで可能
 *   オブジェクトの生成と具体的な処理を分離することで、より柔軟にオブジェクトを利用が可能
 */ 
function Train(options) {
  // default
  this.size = options.size || 2;
  this.state = options.state || "new";
  this.color = options.color || "silver";

}

function Shinkansen(options) {
  this.size = options.size || 12;
  this.color = options.color || "white";
  this.speed = options.speed || 320; 
}

function TrainFactory() { }

TrainFactory.prototype.trainClass = Train;

// factory method
TrainFactory.prototype.createTrain = (options) => {
  switch (options.trainType) {
    case "train":
      this.trainClass = Train;
      break;
    case "sinkansen":
      this.trainClass = Shinkansen;
      break;
  }
  return new this.trainClass(options);
};

// create train
const trainFactory = new TrainFactory();
const train = trainFactory.createTrain({
  trainType: "train",
  color: "yellow"
});

console.log(train);
