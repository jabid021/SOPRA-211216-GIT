export class Produit {
  constructor(private _nom?: string | undefined, private _prix: number = 0) {}

  /**
   * Getter nom
   * @return {string}
   */
  public get nom(): string | undefined {
    return this._nom;
  }

  /**
   * Getter prix
   * @return {number}
   */
  public get prix(): number {
    return this._prix;
  }

  /**
   * Setter nom
   * @param {string} value
   */
  public set nom(value: string | undefined) {
    this._nom = value;
  }

  /**
   * Setter prix
   * @param {number} value
   */
  public set prix(value: number) {
    this._prix = value;
  }
}
