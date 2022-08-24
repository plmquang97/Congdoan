package com.axonactive.congdoan.exception;

public class ResourceNotFoundException extends RuntimeException {
    private static final String CONGDOAN_NOT_FOUND_MSG = "CongDoan not found";

    private static final String DANHMUCTHUCONGDOAN_NOT_FOUND_MSG = "DanhMucThuCongDoan not found";

    private static final String THUCONGDOAN_NOT_FOUND_MSG = "ThuCongDoan not found ";

    public ResourceNotFoundException(String message) {
        super(message);
    }

    public static ResourceNotFoundException CongDoanNotFound() {
        return new ResourceNotFoundException(CONGDOAN_NOT_FOUND_MSG);
    }

    public static ResourceNotFoundException DanhMucThuCongDoanNotFound() {
        return new ResourceNotFoundException(DANHMUCTHUCONGDOAN_NOT_FOUND_MSG);
    }

    public static ResourceNotFoundException ThuCongDoanNotFound() {
        return new ResourceNotFoundException(THUCONGDOAN_NOT_FOUND_MSG);
    }
}
