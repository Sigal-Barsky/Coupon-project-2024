import "./SingleTask.css";
import { Task } from "../../Module/Task";

interface SingleTaskProps {
    task: Task;
}

export function SingleTask({ task }: SingleTaskProps): JSX.Element {
    return (
        <>
            <td>{task.taskName || 'No name provided'}</td>
            <td>{task.inCharge ? task.inCharge.name : 'No in-charge assigned'}</td>
            <td>{task.inCharge ? task.inCharge.phoneNumber : 'No in-charge assigned'}</td>
            <td>{task.endDate || 'No end date provided'}</td>
            <td><input type="checkbox" checked={task.isDone || false} readOnly /></td>
        </>
    );
}
