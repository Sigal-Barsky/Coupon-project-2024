import "./Error.css";
import { useParams, useNavigate } from "react-router-dom";

export function Error(): JSX.Element {
    const { errorMessege } = useParams<{ errorMessege: string }>();
    const navigate = useNavigate(); 

    return (
        <div className="Error">
            <h1>Error!</h1>
            <p>{errorMessege}</p>
            <input type="button" value="Return" onClick={() => navigate(-1)} />
        </div>
    );
}
