package com.main.controllers;

import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.main.models.Shipments;
import com.main.services.ShipmentService;

@RestController
@RequestMapping(path = "api/v1/Shipments")
public class ShipmentsController {

	@Autowired
	private ShipmentService shipmentService;

	@GetMapping
	public ResponseEntity<Shipments> getShipments() {
		return shipmentService.getAllShipments();
	}
	
	@GetMapping("/{ShipmentId}")
	public ResponseEntity<Shipments> getShipmentById(@PathVariable long shipmentId) {
		return shipmentService.getShipmentById(shipmentId);
	}

	@PostMapping
	public ResponseEntity<Shipments> createShipment(@RequestBody Shipments newShipment){
		return shipmentService.createShipment(newShipment);
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<Shipments> deleteShipment(@PathVariable(value="id")Long id){
		return shipmentService.deleteShipment(id);
	}
	@PutMapping("/{id}")
	public ResponseEntity<Shipments>updateShipment(@PathVariable(value="id")Long id, @Validated @RequestBody Shipments newShipment){
		return shipmentService.updateShipment(newShipment, id);
	}
}

