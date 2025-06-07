import { useState } from 'react';
const ToggleMessage = () => {
  const [show1, setShow1] = useState(false);
  const [show2, setShow2] = useState(false);

    const handleClick1 = () => {
        setShow1(!show1);
  }
  const handleClick2 = () => {
    setShow2(!show2);
}
    return (
        <div>
        <button onClick={handleClick1}>{show1 ? 'Hide' : 'Show'} Message</button>
        <button onClick={handleClick2}>{show2 ? 'Hide' : 'Show'} Message</button>
            {show1 &&  show2  &&<p>This is a toggle message!</p>}
        </div>
    );
}
export default ToggleMessage;