package com.ua.armordrive.armor_drive.rest;

import com.ua.armordrive.armor_drive.model.SaleListingDTO;
import com.ua.armordrive.armor_drive.service.SaleListingService;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import jakarta.validation.Valid;
import java.util.List;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping(value = "/api/saleListings", produces = MediaType.APPLICATION_JSON_VALUE)
public class SaleListingResource {

    private final SaleListingService saleListingService;

    public SaleListingResource(final SaleListingService saleListingService) {
        this.saleListingService = saleListingService;
    }

    @GetMapping
    public ResponseEntity<List<SaleListingDTO>> getAllSaleListings() {
        return ResponseEntity.ok(saleListingService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<SaleListingDTO> getSaleListing(@PathVariable(name = "id") final Long id) {
        return ResponseEntity.ok(saleListingService.get(id));
    }

    @PostMapping
    @ApiResponse(responseCode = "201")
    public ResponseEntity<Long> createSaleListing(
            @RequestBody @Valid final SaleListingDTO saleListingDTO) {
        final Long createdId = saleListingService.create(saleListingDTO);
        return new ResponseEntity<>(createdId, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Long> updateSaleListing(@PathVariable(name = "id") final Long id,
            @RequestBody @Valid final SaleListingDTO saleListingDTO) {
        saleListingService.update(id, saleListingDTO);
        return ResponseEntity.ok(id);
    }

    @DeleteMapping("/{id}")
    @ApiResponse(responseCode = "204")
    public ResponseEntity<Void> deleteSaleListing(@PathVariable(name = "id") final Long id) {
        saleListingService.delete(id);
        return ResponseEntity.noContent().build();
    }

}
