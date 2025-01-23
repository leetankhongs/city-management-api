package com.test.city;

import com.test.city.converter.*;
import com.test.city.dto.electricity.ElectricityOutDto;
import com.test.city.dto.waste.WasteInDto;
import com.test.city.dto.waste.WasteOutDto;
import com.test.city.dto.water_supply.WaterSupplyInDto;
import com.test.city.dto.water_supply.WaterSupplyOutDto;
import com.test.city.model.*;
import com.test.city.object_value.DisposalMethod;
import com.test.city.object_value.ReportType;
import com.test.city.object_value.WasteType;
import com.test.city.object_value.WaterSupplyStatus;
import com.test.city.repository.*;
import com.test.city.service.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Arrays;
import java.util.Date;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class CityManagementTests {

    @Mock
    private WaterSupplyRepository waterSupplyRepository;

    @Mock
    private WasteRepository wasteRepository;

    @Mock
    private ElectricityRepository electricityRepository;

    @Mock
    private WaterSupplyConverter waterSupplyConverter;

    @Mock
    private WasteConverter wasteConverter;

    @Mock
    private ElectricityConverter electricityConverter;

    @InjectMocks
    private WaterSupplyService waterSupplyService;

    @InjectMocks
    private WasteService wasteService;

    @InjectMocks
    private ElectricityService electricityService;

    @BeforeEach
    public void setUp() {
        // Setup any common configurations for the tests
    }

    /**
     * Unit Test: View Water Supply Data
     */
    @Test
    public void testGetAllWaterSupply() {
        Date current = new Date();
        WaterSupplyEntity entity = new WaterSupplyEntity();
        entity.setId(1L);
        entity.setCost(2.3);
        entity.setConsumption(3.2);
        entity.setStatus(WaterSupplyStatus.Normal);
        entity.setRecordedAt(current);
        WaterSupplyOutDto dto = new WaterSupplyOutDto();
        dto.setId(1L);
        dto.setCost(2.3);
        dto.setConsumption(3.2);
        dto.setStatus(WaterSupplyStatus.Normal);
        dto.setRecordedAt(current);

        when(waterSupplyRepository.findAll()).thenReturn(List.of(entity));
        when(waterSupplyConverter.toDto(entity)).thenReturn(dto);

        List<WaterSupplyOutDto> result = waterSupplyService.getAllWaterSupply();

        assertEquals(1, result.size());
        assertEquals(2.3, result.get(0).getConsumption());
        assertEquals("Normal", result.get(0).getStatus());
    }

    /**
     * Unit Test: Add Water Supply Data
     */
    @Test
    public void testAddWaterSupply() {
        Date current = new Date();

        WaterSupplyEntity entity = new WaterSupplyEntity();
        entity.setCost(2.3);
        entity.setConsumption(3.2);
        entity.setStatus(WaterSupplyStatus.Normal);
        entity.setRecordedAt(current);
        WaterSupplyInDto inputDto = new WaterSupplyInDto();
        inputDto.setCost(2.3);
        inputDto.setConsumption(3.2);
        inputDto.setStatus(WaterSupplyStatus.Normal);
        when(waterSupplyConverter.toEntity(inputDto)).thenReturn(entity);

        waterSupplyService.saveWaterSupply(inputDto);

        verify(waterSupplyRepository, times(1)).save(entity);
    }

    /**
     * Unit Test: View Waste Data
     */
    @Test
    public void testGetAllWasteData() {
        WasteEntity entity = new WasteEntity();
        entity.setId(1L);
        entity.setType(WasteType.Organic);
        entity.setCollected(true);
        entity.setDisposalMethod(DisposalMethod.Landfill);
        WasteOutDto dto = new WasteOutDto();
        dto.setId(1L);
        dto.setType(WasteType.Organic);
        dto.setCollected(true);
        dto.setDisposalMethod(DisposalMethod.Landfill);

        when(wasteRepository.findAll()).thenReturn(List.of(entity));
        when(wasteConverter.toDto(entity)).thenReturn(dto);

        List<WasteOutDto> result = wasteService.getWasteData();

        assertEquals(1, result.size());
        assertEquals(WasteType.Organic, result.get(0).getType());
        assertEquals(true, result.get(0).isCollected());
    }

    /**
     * Unit Test: Upload Waste Data
     */
    @Test
    public void testUploadWasteData() {
        WasteInDto inputDto = new WasteInDto();
        inputDto.setType(WasteType.Plastic);
        inputDto.setCollected(true);
        inputDto.setDisposalMethod(DisposalMethod.Recycled);
        WasteEntity entity = new WasteEntity();
        entity.setType(WasteType.Plastic);
        entity.setCollected(true);
        entity.setDisposalMethod(DisposalMethod.Recycled);
        when(wasteConverter.toEntity(inputDto)).thenReturn(entity);

        wasteService.saveWasteData(inputDto);

        verify(wasteRepository, times(1)).save(entity);
    }

    /**
     * Unit Test: View Electricity Data
     */
    @Test
    public void testGetElectricityData() {
        ElectricityEntity entity = new ElectricityEntity();
        entity.setId(1L);
        entity.setConsumption(150.0);
        entity.setCost(200.0);
        entity.setReport(ReportType.Normal);
        entity.setRecordedAt(new Date());
        ElectricityOutDto dto = new ElectricityOutDto();
        dto.setId(1L);
        dto.setConsumption(150.0);
        dto.setCost(200.0);
        dto.setReport(ReportType.Normal);
        dto.setRecordedAt(new Date());

        when(electricityRepository.findAll()).thenReturn(List.of(entity));
        when(electricityConverter.toDto(entity)).thenReturn(dto);

        List<ElectricityOutDto> result = electricityService.getElectricityList();

        assertEquals(1, result.size());
        assertEquals(150.0, result.get(0).getConsumption());
    }

    /**
     * Unit Test: Schedule Electricity Data Fetch
     */
    @Test
    public void testScheduleElectricityDataFetch() {
        // Simulate scheduled behavior
        electricityService.getElectricityList();

        // Ensure some internal methods are called
        verify(electricityRepository, times(1)).findAll();
    }
}
