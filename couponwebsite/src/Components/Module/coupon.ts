export class Coupon{
    public id:number;
    public name:string;
    public phoneNumber:string;

    constructor(id:number,name:string, phoneNumber:string){
        this.id=id;
        this.name=name;
        this.phoneNumber=phoneNumber;
    }
}