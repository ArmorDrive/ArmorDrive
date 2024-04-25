package com.ua.armordrive.armor_drive.service;

import com.ua.armordrive.armor_drive.domain.SaleListing;
import com.ua.armordrive.armor_drive.model.SaleListingDTO;
import com.ua.armordrive.armor_drive.repos.SaleListingRepository;
import com.ua.armordrive.armor_drive.util.NotFoundException;
import java.util.List;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;


@Service
public class SaleListingService {

    private final SaleListingRepository saleListingRepository;

    public SaleListingService(final SaleListingRepository saleListingRepository) {
        this.saleListingRepository = saleListingRepository;
    }

    public List<SaleListingDTO> findAll() {
        final List<SaleListing> saleListings = saleListingRepository.findAll(Sort.by("id"));
        return saleListings.stream()
                .map(saleListing -> mapToDTO(saleListing, new SaleListingDTO()))
                .toList();
    }

    public SaleListingDTO get(final Long id) {
        return saleListingRepository.findById(id)
                .map(saleListing -> mapToDTO(saleListing, new SaleListingDTO()))
                .orElseThrow(NotFoundException::new);
    }

    public Long create(final SaleListingDTO saleListingDTO) {
        final SaleListing saleListing = new SaleListing();
        mapToEntity(saleListingDTO, saleListing);
        return saleListingRepository.save(saleListing).getId();
    }

    public void update(final Long id, final SaleListingDTO saleListingDTO) {
        final SaleListing saleListing = saleListingRepository.findById(id)
                .orElseThrow(NotFoundException::new);
        mapToEntity(saleListingDTO, saleListing);
        saleListingRepository.save(saleListing);
    }

    public void delete(final Long id) {
        saleListingRepository.deleteById(id);
    }

    private SaleListingDTO mapToDTO(final SaleListing saleListing,
            final SaleListingDTO saleListingDTO) {
        saleListingDTO.setId(saleListing.getId());
        saleListingDTO.setModel(saleListing.getModel());
        saleListingDTO.setPictures(saleListing.getPictures());
        saleListingDTO.setPrice(saleListing.getPrice());
        saleListingDTO.setSeatsNumber(saleListing.getSeatsNumber());
        saleListingDTO.setEngineDisplacement(saleListing.getEngineDisplacement());
        saleListingDTO.setKilometerage(saleListing.getKilometerage());
        saleListingDTO.setProductionYear(saleListing.getProductionYear());
        saleListingDTO.setPublishingDate(saleListing.getPublishingDate());
        saleListingDTO.setDescription(saleListing.getDescription());
        return saleListingDTO;
    }

    private SaleListing mapToEntity(final SaleListingDTO saleListingDTO,
            final SaleListing saleListing) {
        saleListing.setModel(saleListingDTO.getModel());
        saleListing.setPictures(saleListingDTO.getPictures());
        saleListing.setPrice(saleListingDTO.getPrice());
        saleListing.setSeatsNumber(saleListingDTO.getSeatsNumber());
        saleListing.setEngineDisplacement(saleListingDTO.getEngineDisplacement());
        saleListing.setKilometerage(saleListingDTO.getKilometerage());
        saleListing.setProductionYear(saleListingDTO.getProductionYear());
        saleListing.setPublishingDate(saleListingDTO.getPublishingDate());
        saleListing.setDescription(saleListingDTO.getDescription());
        return saleListing;
    }

}
