// 対象
export class Target {
    public request(): string {
        return 'Target: Response';
    }
}

// アダプタされるもの
export class Adaptee {
    public specificRequest(): string {
        return 'Adaptee: Response';
    }
}

// アダプタ
export class Adapter extends Target {
    private adaptee: Adaptee;

    constructor(adaptee: Adaptee) {
        super();
        this.adaptee = adaptee;
    }

    // Override
    public request(): string {
        const result = this.adaptee.specificRequest();
        return `Adapter: (TRANSLATED) ${result}`;
    }
}



