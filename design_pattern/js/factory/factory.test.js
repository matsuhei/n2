const factory = require('./factory');

test('factory', () => {
  const train = factory.createTrain({
    trainType: "train",
    color: "yellow"
  });

  // public value assert
  expect(train.size).toBe(2);
  expect(train.color).toBe("yellow");
  expect(train.state).toBe("new");
});
