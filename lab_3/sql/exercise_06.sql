USE QLSV;
GO

ALTER TABLE SinhVien
ALTER COLUMN HoTen VARCHAR(100) NOT NULL;

CREATE PROCEDURE InsertStudent
   @MaSV NVARCHAR(10),
   @HoTen NVARCHAR(100),
   @Lop NVARCHAR(50),
   @DiemTB DECIMAL(4, 2)
AS
BEGIN
   INSERT INTO SinhVien (MaSV, HoTen, Lop, DiemTB)
   VALUES (@MaSV, @HoTen, @Lop, @DiemTB);
END;

CREATE PROCEDURE UpdateStudent
    @MaSV NVARCHAR(10),
    @HoTen NVARCHAR(100),
    @Lop NVARCHAR(50),
    @DiemTB DECIMAL(4, 2)
AS
BEGIN
    UPDATE SinhVien
    SET HoTen = @HoTen, Lop = @Lop, DiemTB = @DiemTB
    WHERE MaSV = @MaSV;
END;

CREATE PROCEDURE DeleteStudent
    @MaSV NVARCHAR(10)
AS
BEGIN
    DELETE FROM SinhVien
    WHERE MaSV = @MaSV;
END;

CREATE PROCEDURE SortStudentsByGPA
    @Ascending BIT
AS
BEGIN
    DECLARE @SortOrder NVARCHAR(4);

    IF @Ascending = 1
        SET @SortOrder = 'ASC';
    ELSE
        SET @SortOrder = 'DESC';

    DECLARE @SqlQuery NVARCHAR(MAX);
    SET @SqlQuery = 'SELECT * FROM SinhVien ORDER BY DiemTB ' + @SortOrder;

    EXEC sp_executesql @SqlQuery;
END;
