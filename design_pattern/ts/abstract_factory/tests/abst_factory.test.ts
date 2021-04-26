import {clientCode, ConcreteFactoryA, ConcreteFactoryB} from "#/abst_factory";
import * as assert from "assert";

describe('abst', (): void => {
    test('clientCode', (): void => {
        const a = clientCode(new ConcreteFactoryA());
        assert.deepStrictEqual(a.usefulFunction(), 'The result of the product A.');

        const b = clientCode(new ConcreteFactoryB());
        assert.deepStrictEqual(b.usefulFunction(), 'The result of the product B.');
    });
})
