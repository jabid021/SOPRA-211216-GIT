export class MaClass {
  // //attributs
  // private _prenom: string;
  // private nom: string | undefined;

  // constructor(prenom: string = '', nom?: string) {
  //   this._prenom = prenom;
  //   this.nom = nom;
  // }

  static attributDeClass: string = 'hello';

  constructor(private _prenom: string = '', private _nom?: string) {}

  // get prenom() {
  //   return this._prenom;
  // }

  // set prenom(value: string) {
  //   this._prenom = value;
  // }

  // get nom(): string | undefined {
  //   return this._nom;
  // }

  // set nom(value: string | undefined) {
  //   this._nom = value;
  // }

  // methode() {
  //   this.prenom = 'olivier';
  //   console.log(this.prenom);
  // }
}
