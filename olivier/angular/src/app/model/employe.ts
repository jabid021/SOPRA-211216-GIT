import { Departement } from './departement';
import { Adresse } from './adresse';
import { Civilite } from './civilite';
export class Employe {
  private _id: number | undefined;
  private _nom: string | undefined;
  private _salaire: number | undefined;
  private _commission: number | undefined;
  private _dateEmbauche: Date | undefined;
  private _civilite: Civilite | undefined;
  private _adresse: Adresse | undefined;
  private _departement: Departement | undefined;

  constructor(
    id?: number,
    nom?: string,
    salaire?: number,
    commission?: number,
    dateEmbauche?: Date,
    civilite?: Civilite,
    adresse?: Adresse,
    departement?: Departement
  ) {
    this._id = id;
    this._nom = nom;
    this._salaire = salaire;
    this._commission = commission;
    this._dateEmbauche = dateEmbauche;
    this._civilite = civilite;
    this._adresse = adresse;
    this._departement = departement;
  }

  /**
   * Getter id
   * @return {number }
   */
  public get id(): number | undefined {
    return this._id;
  }

  /**
   * Getter nom
   * @return {string }
   */
  public get nom(): string | undefined {
    return this._nom;
  }

  /**
   * Getter salaire
   * @return {number }
   */
  public get salaire(): number | undefined {
    return this._salaire;
  }

  /**
   * Getter commission
   * @return {number }
   */
  public get commission(): number | undefined {
    return this._commission;
  }

  /**
   * Getter dateEmbauche
   * @return {Date }
   */
  public get dateEmbauche(): Date | undefined {
    return this._dateEmbauche;
  }

  /**
   * Getter civilite
   * @return {Civilite }
   */
  public get civilite(): Civilite | undefined {
    return this._civilite;
  }

  /**
   * Getter adresse
   * @return {Adresse }
   */
  public get adresse(): Adresse | undefined {
    return this._adresse;
  }

  /**
   * Getter departement
   * @return {Departement }
   */
  public get departement(): Departement | undefined {
    return this._departement;
  }

  /**
   * Setter id
   * @param {number } value
   */
  public set id(value: number | undefined) {
    this._id = value;
  }

  /**
   * Setter nom
   * @param {string } value
   */
  public set nom(value: string | undefined) {
    this._nom = value;
  }

  /**
   * Setter salaire
   * @param {number } value
   */
  public set salaire(value: number | undefined) {
    this._salaire = value;
  }

  /**
   * Setter commission
   * @param {number } value
   */
  public set commission(value: number | undefined) {
    this._commission = value;
  }

  /**
   * Setter dateEmbauche
   * @param {Date } value
   */
  public set dateEmbauche(value: Date | undefined) {
    this._dateEmbauche = value;
  }

  /**
   * Setter civilite
   * @param {Civilite } value
   */
  public set civilite(value: Civilite | undefined) {
    this._civilite = value;
  }

  /**
   * Setter adresse
   * @param {Adresse } value
   */
  public set adresse(value: Adresse | undefined) {
    this._adresse = value;
  }

  /**
   * Setter departement
   * @param {Departement } value
   */
  public set departement(value: Departement | undefined) {
    this._departement = value;
  }
}
