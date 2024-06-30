import { Person } from "./Person";
export class Task{
    public id:number;
    public taskName:string;
    public inCharge:Person;
    public endDate:string;
    public isDone:boolean;

    constructor(id:number,taskName:string,inCharge:Person,endDate:string, isDone:boolean){
        this.id=id;
        this.taskName=taskName;
        this.inCharge=inCharge;
        this.endDate=endDate;
        this.isDone=isDone;
    }
}

