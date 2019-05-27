package com.app.messagingservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.app.messagingservice.entity.OtpMaster;

@Repository
public interface OtpRepository extends JpaRepository<OtpMaster, Long>{

	@Query("SELECT o FROM OtpEntity o WHERE o.sapCode = :sapCode and o.uuid =:uuid and o.otpValue =:otp_value and expireTime > CURRENT_TIMESTAMP()")
	OtpMaster findByUserId(@Param("sapCode") String sapCode, @Param("uuid") String uuid, @Param("otp_value") int otp_value);

}
