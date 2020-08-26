package model.entities;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

public class Reservation {
	
	private Integer roomNumber;
	private Date checkIn;
	private Date checkOut;
	
	private static SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
	
	public Reservation() {
	}

	public Reservation(Integer roomNumber, Date checkIn, Date checkOut) {
		this.roomNumber = roomNumber;
		this.checkIn = checkIn;
		this.checkOut = checkOut;
	}

	public Integer getRoomNumber() {
		return roomNumber;
	}

	public void setRoomNumber(Integer roomNumber) {
		this.roomNumber = roomNumber;
	}

	public Date getCheckIn() {
		return checkIn;
	}

	public Date getCheckOut() {
		return checkOut;
	}
	
	public long duration () {
		long diff = checkOut.getTime() - checkIn.getTime();//Calculando a diferença das datas em milisegundos
		return TimeUnit.DAYS.convert(diff, TimeUnit.MILLISECONDS); //convertendo a diferença em milisegundos para dias
	}
	
	public String updateDates(Date checkIn, Date checkOut) {
		//exemplo de forma de verificação ruim
		Date now = new Date();
		if(checkIn.before(now) || checkOut.before(now)) {
			return "Error in reservation: Reservation date for update must be future dates";	
		}
		if (!checkOut.after(checkIn)){
			return"Error in reservation: Check-out date must be after check-in date";
		}
		this.checkIn = checkIn;
		this.checkOut = checkOut;
		return null;
	}
	
	@Override
	public String toString() {
		return "Room " 
				+ roomNumber 
				+ ", check-in: " 
				+sdf.format(checkIn) 
				+", chech-out: " 
				+ sdf.format(checkOut) 
				+", duration: " 
				+duration() 
				+ " nights";
	}
	

}
