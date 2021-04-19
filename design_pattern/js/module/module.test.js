const modulePattern = require('./module');

test('module', () => {
  modulePattern.log();
  modulePattern.updateMyConfig({
    language: "jp",
    useCaching: false
  });
  // public value assert
  expect(modulePattern.getMyConfig()).toEqual({
    language: "jp",
    useCaching: false
  });
});
