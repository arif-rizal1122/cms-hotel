import React, { useEffect, useState } from 'react'
import { getRoomTypes } from '../utils/ApiFunctions'


const RoomTypeSelector = ({handleRoomInputChange, newRoom}) => {

    const[roomTypes, setRoomTypes] = useState([""])
    const[showNewRoomTypeInput, setShowNewRoomTypeInput] = useState(false)
    const[newRoomType, setNewRoomTypes] = useState("") 

    useEffect(() => {
        getRoomTypes().then((data) => {
            setRoomTypes(data)
        })
    }, [])


    const handleNewRoomTypeInputChange = (e) => {
        setNewRoomTypes(e.target.value)
    }

    const handleAddNewRoomType = () => {
        if (newRoomType !== null) {
            setRoomTypes([...roomTypes, newRoomType])
            setNewRoomTypes("")
            setShowNewRoomTypeInput(false)
        }
    }

    return (
        <>
        
        {roomTypes.length > 0 && (
    <div>
         
         <select className="form-control mb-2"
        name="roomType"
        id="roomType"
        value={newRoom?.roomType || ""}
        onChange={(e) => {
            if (e.target.value === "add new type") {
                setShowNewRoomTypeInput(true);
            } else {
                handleRoomInputChange(e);
            }
        }}>
        <option value="">Select a room type</option>
        <option value="add new type">Add new type</option>
        {roomTypes.map((type, index) => (
            <option key={index} value={type}>
                {type}
            </option>
        ))}
       </select>


        {showNewRoomTypeInput && (
            <div className='input-group'>
                <input type="text" 
                       className='form-control'
                       placeholder='enter a new room type'
                       onChange={handleNewRoomTypeInputChange}>
                </input>

                <button className='btn-hotel' type='button' onClick={handleAddNewRoomType}>
                    add
                </button>
            </div>
        )}        


    </div>
        )}


        </>
    )


}

export default RoomTypeSelector