import "./Main.css";
import { useState, useEffect } from "react";
import axios from "axios";
import { Task } from "../../Module/Task";
import { SingleTask } from "../SingleTask/SingleTask";
import { useNavigate } from "react-router-dom";

export function Main(): JSX.Element {
    const [tasks, setTasks] = useState<Task[]>([]);
    const [selectedTask, setSelectedTask] = useState<Task | null>(null);
    const navigate = useNavigate();

    useEffect(() => {
        axios.get("http://localhost:8080/api/v1/task/list").then(res => {
            let returnTasks = [];
            for (let index = 0; index < res.data.length; index++) {
                returnTasks.push(res.data[index]);
            }
            setTasks(returnTasks);
        });
    }, []);

    const handleRadioChange = (task: Task) => {
        setSelectedTask(task);
    };

    const handleDeleteClick = () => {
        if (selectedTask) {
            navigate(`/delete/${selectedTask.id}`);
        }
    };

    const handleUpdateClick = () => {
        if (selectedTask) {
            navigate(`/updateTask/${selectedTask.id}`);
        }
    };

    return (
        <div className="Main">
            <h1>Tasks
                <button onClick={handleDeleteClick}>Delete Task</button>
                <button onClick={handleUpdateClick}>Update Task</button>
            </h1>
            <table>
                <tr>
                    <th>Select</th>
                    <th>Task name</th>
                    <th>Person in charge</th>
                    <th>Phone number</th>
                    <th>Deadline</th>
                    <th>Completion Status</th>
                </tr>
                {tasks.map(task => (
                    <tr key={task.id}>
                        <td>
                            <input
                                type="radio"
                                name="taskSelection"
                                checked={selectedTask ? selectedTask.id === task.id : false}
                                onChange={() => handleRadioChange(task)}
                            />
                        </td>
                        <SingleTask task={task} />
                    </tr>
                ))}
            </table>
        </div>
    );
}
