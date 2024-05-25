export class SupplyDTO {
  constructor(public supplierId: number, public productId: number, public quantity:number, public supplyDate: Date, public id?: number) {
  }
}
