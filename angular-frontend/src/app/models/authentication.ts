export class Authentication {
    private _jwt: string;
    private _expirationTime: number;


    constructor(jwt: string, expirationTime: number) {
        this._jwt = jwt;
        this._expirationTime = expirationTime;
    }


    get jwt(): string {
        return this._jwt;
    }

    set jwt(value: string) {
        this._jwt = value;
    }

    get expirationTime(): number {
        return this._expirationTime;
    }

    set expirationTime(value: number) {
        this._expirationTime = value;
    }
}
