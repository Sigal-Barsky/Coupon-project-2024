import { Route, Routes } from "react-router-dom";
import { Main } from "../../Pages/Main/Main";
import { AddTask } from "../../Pages/AddTask/AddTask";
import { Confirm } from "../../Pages/Confirm/Confirm";
import { Error } from "../../Pages/Error/Error";
import { DeleteTask } from "../../Pages/DeleteTask/DeleteTask";
import { UpdateTask } from "../../Pages/UpdateTask/UpdateTask";
import { Page404 } from "../../Pages/page404/page404";
import "./MainRoute.css";

export function MainRoute(): JSX.Element {
    return (
        <div className="MainRoute">
			<Routes>
                <Route path="/" element={<Main/>}/>
                <Route path="/add" element={<AddTask/>}/>
                <Route path="/confirmation/:taskName/:inChargeName/:inChargePhone/:endDate/:isDone" element={<Confirm/>}/>
                <Route path="/error/:errorMessage" element={<Error/>}/>
                <Route path="/delete/:taskId" element={<DeleteTask/>}/>
                <Route path="/updateTask/:taskId" element={<UpdateTask/>}/>
                <Route path="*" element={<Page404/>}/>
            </Routes>
        </div>
    );
}

