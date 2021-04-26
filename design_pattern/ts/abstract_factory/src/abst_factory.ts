// 抽象ファクトリ(interface)
interface AbstractFactory {
    create(): AbstractProduct;
}

export class ConcreteFactoryA implements AbstractFactory {
    public create(): AbstractProduct {
        return new ConcreteProductA();
    }
}

export class ConcreteFactoryB implements AbstractFactory {
    public create(): AbstractProduct {
        return new ConcreteProductB();
    }
}

// 抽象プロダクト(interface)
interface AbstractProduct {
    usefulFunction(): string;
}

class ConcreteProductA implements AbstractProduct {
    public usefulFunction(): string {
        return 'The result of the product A.';
    }
}

class ConcreteProductB implements AbstractProduct {
    public usefulFunction(): string {
        return 'The result of the product B.';
    }
}

// 呼び出し部分
export function clientCode(factory: AbstractFactory) {
    return factory.create();
}
