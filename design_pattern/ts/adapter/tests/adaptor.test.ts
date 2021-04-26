import {Target, Adapter, Adaptee} from '#/adaptor';
import * as assert from "assert";

describe('adaptor', (): void => {
    test('adaptor ex.', (): void => {

        const target = new Target();
        assert.deepStrictEqual(target.request(), 'Target: Response');

        const adaptee = new Adaptee();
        assert.deepStrictEqual(adaptee.specificRequest(), 'Adaptee: Response');

        const adapter = new Adapter(adaptee);
        assert.deepStrictEqual(adapter.request(), 'Adapter: (TRANSLATED) Adaptee: Response');
    });
})
