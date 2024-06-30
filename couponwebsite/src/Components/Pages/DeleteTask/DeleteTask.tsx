import "./DeleteTask.css";
import { useNavigate, useParams } from "react-router-dom";
import axios from "axios";

export function DeleteTask(): JSX.Element {
    const navigate = useNavigate();
    const {taskId} = useParams<{ taskId: string}>();


    const handleDelete = () => {
        console.log(taskId)
        axios.get(`http://localhost:8080/api/v1/task/delete/${taskId}`).then(res=>{
            navigate("/")
        })
};

return (
    <div className="Confirm">
        <h1>Are you sure you want to delete this task?</h1>
        {taskId}
        <br/>
        <input type="button" value="Yes" onClick={handleDelete} />
        <input type="button" value="No" onClick={() => navigate(-1)} />
    </div>
);
}
