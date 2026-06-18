/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author soniy
 */
interface HotelManagements {
    void bookRoom(int roomNumber, String customerName, String mobileNumber);
    void checkoutRoom(int roomNumber);
    void showRoomStatus();
}

class CustomerDetails 

{
    String name;
    String mobile;
    CustomerDetails(String name, String mobile)
    {
        this.name = name;
        this.mobile = mobile;
    }
    public String toString() 
    {
        return "Name: " + name + ", Mobile: " + mobile;
    }
}

abstract class BaseHotel implements HotelManagements 
{
    private CustomerDetails[] rooms;
    public BaseHotel(int numRooms) 
    {
        rooms = new CustomerDetails[numRooms];
    }

    public void bookRoom(int roomNumber, String name, String mobile) 
    {
        if (isValid(roomNumber))
        {
            if (rooms[roomNumber] == null) 
            {
                rooms[roomNumber] = new CustomerDetails(name, mobile);
                System.out.println("[" + getType() + "] Room " + roomNumber + " booked by " + name + extraInfo());
            } 
            else
            {
                System.out.println("[" + getType() + "] Room " + roomNumber + " already booked.");
            }
        }
    }

    public void checkoutRoom(int roomNumber) 
    {
        if (isValid(roomNumber)) 
        
        {
            if (rooms[roomNumber] != null) 
            {
                System.out.println("[" + getType() + "] " + rooms[roomNumber].name + " checked out from Room " + roomNumber);
                rooms[roomNumber] = null;
            } 
            else 
            {
                System.out.println("[" + getType() + "] Room " + roomNumber + " is not booked.");
            }
        }
    }

    public void showRoomStatus() 
    {
        System.out.println("\n[" + getType() + "] Room Status:");
        for (int i = 0; i < rooms.length; i++)
            System.out.println("Room " + i + ": " + (rooms[i] == null ? "Available" : rooms[i] + statusInfo()));
    }

    private boolean isValid(int roomNumber) 
    {
        if (roomNumber < 0 || roomNumber >= rooms.length) 
        
        {
            System.out.println("[" + getType() + "] Invalid room number.");
            return false;
        }
        return true;
    }

    abstract String getType();
    abstract String extraInfo();
    abstract String statusInfo();
}

class Hotel extends BaseHotel {
    Hotel(int n) 
    {
        super(n);
    }
    String getType() 
    {
        return "Hotel"; 
    }
    String extraInfo()
    {
        return "";
    }
    String statusInfo()
    {
        return ""; 
    }
}

class Resort extends BaseHotel {
    Resort(int n)
    {
        super(n);
    }
    String getType()
    {
        return "Resort";
    }
    String extraInfo() 
    { 
        return ". Pool access included!";
    }
    String statusInfo() 
    {
        return " | Pool Access ✔";
    }
}
public class HotelManagement {
    public static void main(String[] args) {
        HotelManagements hotel = new Hotel(3);
        hotel.bookRoom(0, "Ravi", "9876543210");
        hotel.bookRoom(1, "Sneha", "9123456789");
        hotel.showRoomStatus();
        hotel.checkoutRoom(1);
        hotel.showRoomStatus();

        System.out.println("\n----------------------------------------");

        HotelManagements resort = new Resort(2);
        resort.bookRoom(0, "Kiran", "9012345678");
        resort.showRoomStatus();
        resort.checkoutRoom(0);
        resort.showRoomStatus();
    }
}
    

