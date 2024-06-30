import "./Confirm.css";
import { useNavigate, useParams } from "react-router-dom";
import axios from "axios";
import { Person } from "../../Module/Person";

export function Confirm(): JSX.Element {
    const navigate = useNavigate();
    const { taskName, inChargeName, inChargePhone, endDate, isDone } = useParams<{ taskName: string, inChargeName: string, inChargePhone: string, endDate: string, isDone: string }>();

    const handleConfirm = () => {
        const data = {
            taskName,
            inCharge: {
                name: inChargeName,
                phoneNumber: inChargePhone
            },
            endDate,
            isDone
        };
        axios.post("http://localhost:8080/api/v1/task/add", data).then(res=>{
            navigate("/")
        })
    };

    return (
        <div className="Confirm">
            <h1>Are you sure you want to add this task?</h1>
            <b>Task Name: </b> {taskName || "No task name provided"}
            <br/>
            <b>Person In Charge: </b> {inChargeName || "No in-charge provided"}
            <br/>
            <b>End Date: </b> {endDate || "No end date provided"}
            <br/>
            <input type="button" value="Yes" onClick={handleConfirm} />
            <input type="button" value="No" onClick={() => navigate(-1)} />
        </div>
    );
}
