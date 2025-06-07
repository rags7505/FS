import { Link } from "react-router-dom";
const Navbar = () => {

    return ( 
        <nav>
            <ul>
                <li><Link to ="/greeting">Greetings</Link></li>
                <li><Link to ="/counter">Counter</Link></li>
                <li><Link to="/userInfo">UserInfo</Link></li>
                <li><Link to="/toggleMessage">ToggleMessage</Link></li>
                <li><Link to="/calculator">Calculator</Link></li>
                <li><Link to="/validForm">ValidForm</Link></li>
                <li><Link to="/shoppingCart">Shopping</Link></li>
            </ul>
        </nav>
     );
}
 
export default Navbar;