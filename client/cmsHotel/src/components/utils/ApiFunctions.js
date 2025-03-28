import axios from 'axios'


export const api = axios.create({
    baseURL :"http://localhost:8080"
})


/* this function add new room  */
export async function addRoom(photo, roomType, roomPrice) {
    
    const formData = new FormData();
    formData.append("photo", photo)
    formData.append("roomType", roomType)
    formData.append("roomPrice", roomPrice)

    const response = await api.post("/rooms/add/newRoom", formData)
    if (response.status == 201) {
        return true
    } else {
        return false
    }

}

/* this function gets all room types from the database */ 
export async function getRoomTypes() {
    try{
        const response = await api.get("/rooms/room-types")
        return response.data
    } catch(error) {
        throw new Error("Error Fatching Room Type");
    }
}