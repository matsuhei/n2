// 抽選 メソッド
const doLottery = (ids, size) => {
	return getRandom(ids, size);
}

// 抽選 ランダム
const getRandom = (ids, size) => {
	const indexes = [];
	const results = [];
	for (let i = 0; i <= size - 1; i++) {
		while (true) {
			const index = Math.floor(Math.random() * (ids.length));
			if (!indexes.includes(index)) {
				indexes.push(index);
				results.push(ids[index]);
				break;
			}
		}
	}
	return results;
}

module.exports = {
	doLottery
};