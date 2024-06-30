import "./AddTask.css";
import axios from "axios";
import { useNavigate } from "react-router-dom";
import { Task } from "../../Module/Task";
import { SubmitHandler, useForm } from "react-hook-form";
import { useState } from 'react';

export function AddTask(): JSX.Element {
    const navigate = useNavigate();
    const { register, handleSubmit, formState: { errors } } = useForm<Task>();
    const [formData, setFormData] = useState<Task | null>(null);

    const onSubmit: SubmitHandler<Task> = (data) => {
        console.log(data);
        data.isDone = false;
        
        setFormData(data);
        if (data.taskName && data.inCharge && data.inCharge.name && data.inCharge.phoneNumber && data.endDate) {
            navigate(`/confirmation/${data.taskName}/${data.inCharge.name}/${data.inCharge.phoneNumber}/${data.endDate}/${data.isDone}`);
        } else {
           navigate("/error/Missing required task data, make sure to fill all fields")
        }
    }

    return (
        <div className="AddTask">
            <div className="table">
                <form onSubmit={handleSubmit(onSubmit)}>
                    <h1>Add Task</h1><hr />
                    <input type="text" placeholder="task name" {...register("taskName")} />
                    <br /><br />
                    <input type="text" placeholder="name of person in charge" {...register("inCharge.name")}/>
                    <br /><br />
                    <input type="text" placeholder="phone number" {...register("inCharge.phoneNumber")}/>
                    <br /><br />
                    <input type="date" placeholder="end date" {...register("endDate")}/>
                    <br /><br />
                    <input type="submit" value="add task" />
                </form>
            </div>
        </div>
    );
}

