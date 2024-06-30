import "./UpdateTask.css";
import axios from "axios";
import { Task } from "../../Module/Task";
import { useParams, useNavigate } from "react-router-dom";
import { useEffect, useState } from "react";
import { useForm, SubmitHandler } from "react-hook-form";

export function UpdateTask(): JSX.Element {
    const {taskId} = useParams<{ taskId: string }>();
    const [task, setTask] = useState<Task | null>(null);
    const navigate = useNavigate();
    const { register, handleSubmit, formState: { errors } } = useForm<Task>();
    const [formData, setFormData] = useState<Task | null>(null);

    const onSubmit: SubmitHandler<Task> = (data) => {
        console.log(data);
        if (task) {
            data = task
            console.log(data);
            axios.put(`http://localhost:8080/api/v1/task/update/${taskId}`, task).then(res => {
                navigate(`/`);
            });
        }
    }

    useEffect(() => {
        axios.get(`http://localhost:8080/api/v1/task/get/${taskId}`).then(res => {
            setTask(res.data);
        });
    }, [taskId]);

    const handleInputChange = (e: React.ChangeEvent<HTMLInputElement>, field: string) => {
        if (task) {
            const { name, value, type, checked } = e.target;
            let newValue = type === 'checkbox' ? checked : value;

            // Handling nested paths like 'inCharge.name'
            const keys = field.split('.');
            if (keys.length > 1) {
                // Nested property
                const [outerKey, innerKey] = keys;
                const outerValue = task[outerKey as keyof typeof task];
                if (typeof outerValue === 'object' && outerValue !== null) {
                    const updatedOuter = { ...outerValue, [innerKey]: newValue };
                    setTask({ ...task, [outerKey]: updatedOuter });
                }
            } else {
                // Direct property
                setTask({ ...task, [field as keyof Task]: newValue });
            }
        }
    };

    return (
        <div className="UpdateTask">
            <form onSubmit={handleSubmit(onSubmit)}>
                <table>
                    <thead>
                        <tr>
                            <th>Task name</th>
                            <th>Person in charge</th>
                            <th>Phone number</th>
                            <th>Deadline</th>
                            <th>Completion Status</th>
                        </tr>
                    </thead>
                    <tbody>
                        {task && (
                            <tr>
                                <td><input type="text" value={task.taskName} onChange={(e) => handleInputChange(e, 'taskName')} /></td>
                                <td><input type="text" value={task.inCharge.name} onChange={(e) => handleInputChange(e, 'inCharge.name')} /></td>
                                <td><input type="text" value={task.inCharge.phoneNumber} onChange={(e) => handleInputChange(e, 'inCharge.phoneNumber')} /></td>
                                <td><input type="date" value={task.endDate} onChange={(e) => handleInputChange(e, 'endDate')} /></td>
                                <td><input type="checkbox" checked={task.isDone} onChange={(e) => handleInputChange(e, 'isDone')} /></td>
                            </tr>
                        )}
                    </tbody>
                </table>
                my update doesnt work and i cant figure out why<br />
                <button type="submit">Update Task</button>
            </form>
        </div>
    );
}
