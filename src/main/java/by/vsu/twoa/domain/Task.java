package by.vsu.twoa.domain;

import by.vsu.twoa.geometry.Circle;
import by.vsu.twoa.geometry.Point;
import by.vsu.twoa.geometry.Square;

import java.util.Date;

public class Task extends Entity {
	private User owner;
	private String name;
	private Date created;
	private Point vertex1;
	private Point vertex2;
	private Square squareVariant1;
	private Circle inscribedCircleVariant1;
	private Square squareVariant2;
	private Circle inscribedCircleVariant2;

	public User getOwner() {
		return owner;
	}

	public void setOwner(User owner) {
		this.owner = owner;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Date getCreated() {
		return created;
	}

	public void setCreated(Date created) {
		this.created = created;
	}

	public Point getVertex1() {
		return vertex1;
	}

	public void setVertex1(Point vertex1) {
		this.vertex1 = vertex1;
	}

	public Point getVertex2() {
		return vertex2;
	}

	public void setVertex2(Point vertex2) {
		this.vertex2 = vertex2;
	}

	public Square getSquareVariant1() {
		return squareVariant1;
	}

	public void setSquareVariant1(Square squareVariant1) {
		this.squareVariant1 = squareVariant1;
	}

	public Circle getInscribedCircleVariant1() {
		return inscribedCircleVariant1;
	}

	public void setInscribedCircleVariant1(Circle inscribedCircleVariant1) {
		this.inscribedCircleVariant1 = inscribedCircleVariant1;
	}

	public Square getSquareVariant2() {
		return squareVariant2;
	}

	public void setSquareVariant2(Square squareVariant2) {
		this.squareVariant2 = squareVariant2;
	}

	public Circle getInscribedCircleVariant2() {
		return inscribedCircleVariant2;
	}

	public void setInscribedCircleVariant2(Circle inscribedCircleVariant2) {
		this.inscribedCircleVariant2 = inscribedCircleVariant2;
	}
}
