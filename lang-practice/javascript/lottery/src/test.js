const {doLottery} = require('./lottery');

const ids = [
    "111", "222", "333", "444", "555"
];
// 抽選結果取得
const result = doLottery(ids, 3);
console.log(result);
console.log(result.length === 3);
