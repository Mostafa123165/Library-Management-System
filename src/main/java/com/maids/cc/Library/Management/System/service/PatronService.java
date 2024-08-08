package com.maids.cc.Library.Management.System.service;

import com.maids.cc.Library.Management.System.dto.request.PatronRequestDto;
import com.maids.cc.Library.Management.System.entities.Patron;
import com.maids.cc.Library.Management.System.exceptions.BadRequestException;
import com.maids.cc.Library.Management.System.exceptions.NotFoundCustomException;
import com.maids.cc.Library.Management.System.mapper.PatronMapper;
import com.maids.cc.Library.Management.System.repository.BorrowingRecordRepository;
import com.maids.cc.Library.Management.System.repository.PatronRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@AllArgsConstructor
public class PatronService {

    private PatronRepository patronRepository;
    private BorrowingRecordRepository borrowingRecordRepository;
    private PatronMapper patronMapper;

    @Transactional
    public List<Patron> findAll() {

        return patronRepository.findAll();
    }

    @Transactional
    public Patron findById(Long id) {

        return checkPatronIsExistedByIdOrThrowException(id);
    }

    @Transactional
    public Patron addNewPatron(PatronRequestDto patronRequestDto) {

        checkPatronIsNotExistedByPhoneOrThrowException(patronRequestDto.getPhone());
        checkPatronIsNotExistedByEmailOrThrowException(patronRequestDto.getEmail());

        Patron patron  = patronMapper.mapToPatron(patronRequestDto);

        return patronRepository.save(patron);
    }

    @Transactional
    public Patron update(PatronRequestDto patronRequestDto) {

        checkPatronIsExistedByIdOrThrowException(patronRequestDto.getId());
        Patron patron  = patronMapper.mapToPatron(patronRequestDto);
        patron.setId(patronRequestDto.getId());

        return patronRepository.save(patron);
    }

    @Transactional
    public void delete(Long id) {

        Patron patron = checkPatronIsExistedByIdOrThrowException(id);
        if(borrowingRecordRepository.existsByPatron(patron)) {
            throw new BadRequestException("Cannot delete patron with ID " + id + " because they currently have active borrowing records. Please resolve or return all borrowed book before deleting.");
        }
        patronRepository.deleteById(id);
    }

    private Patron checkPatronIsExistedByIdOrThrowException(Long id) {
        if(id == null) throw new NotFoundCustomException("id is required");
        return patronRepository.findById(id).orElseThrow(
                () -> new NotFoundCustomException("Patron with Id " + id + " not found"));
    }

    private void checkPatronIsNotExistedByPhoneOrThrowException(String phone) {
        if (patronRepository.findByPhone(phone).isPresent()) {
            throw new NotFoundCustomException("Patron with phone " + phone + " already exists.");
        }
    }

    private void checkPatronIsNotExistedByEmailOrThrowException(String email) {
        if (patronRepository.findByEmail(email).isPresent()) {
            throw new NotFoundCustomException("Patron with email " + email + " already exists.");
        }
    }


}
