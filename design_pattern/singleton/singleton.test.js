const singleton = require('./singleton');

test('singleton', () => {
  // public value assert
  expect(singleton.publicProperty).toBe('public value');
});
