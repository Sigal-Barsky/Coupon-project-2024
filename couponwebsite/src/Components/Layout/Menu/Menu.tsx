import { NavLink } from "react-router-dom";
import "./Menu.css";

export function Menu(): JSX.Element {
    return (
        <div className="Menu">
            <table>
             <tr>
                <td> <b><NavLink to="/"> MAIN </NavLink></b> </td>
             </tr>
             <tr>
                <td> <b> <NavLink to="/add"> ADD NEW TASK </NavLink> </b> </td>
             </tr>
            
            </table>
        </div>
    );
}
