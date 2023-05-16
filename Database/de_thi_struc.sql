--
-- File generated with SQLiteStudio v3.3.3 on Tue May 16 10:06:43 2023
--
-- Text encoding used: System
--
PRAGMA foreign_keys = off;
BEGIN TRANSACTION;

-- Table: de_thi_anh
DROP TABLE IF EXISTS de_thi_anh;

CREATE TABLE de_thi_anh (
    maDe          STRING  REFERENCES ma_de (maDe) ON DELETE NO ACTION
                                                  ON UPDATE NO ACTION,
    cau           INTEGER NOT NULL,
    noiDungCauHoi TEXT    NOT NULL,
    A             TEXT    NOT NULL,
    B             TEXT    NOT NULL,
    C             TEXT    NOT NULL,
    D             TEXT    NOT NULL,
    dapAnDung     TEXT    NOT NULL,
    loiGiai       TEXT,
    dapAnChon     TEXT
);

INSERT INTO de_thi_anh (maDe, cau, noiDungCauHoi, A, B, C, D, dapAnDung, loiGiai, dapAnChon) VALUES ('anh1', 5, 'She ___________  book for more than 2 hours.', 'read', 'is reading', 'has read', 'reads', 'has read', NULL, NULL);
INSERT INTO de_thi_anh (maDe, cau, noiDungCauHoi, A, B, C, D, dapAnDung, loiGiai, dapAnChon) VALUES ('anh1', 4, 'Peter tried his best and passed the driving test at the first _______. ', 'try', 'attempt', 'doing', 'aim', 'try', NULL, NULL);
INSERT INTO de_thi_anh (maDe, cau, noiDungCauHoi, A, B, C, D, dapAnDung, loiGiai, dapAnChon) VALUES ('anh1', 3, 'Whenever problems come up, we discuss them frankly and find solutions quickly.', 'happen', 'encounter', 'arrive', 'clean', 'happen', NULL, NULL);
INSERT INTO de_thi_anh (maDe, cau, noiDungCauHoi, A, B, C, D, dapAnDung, loiGiai, dapAnChon) VALUES ('anh1', 2, 'Many school clubs are _______ efforts to attract more students to join.', 'doing', 'giving', 'cutting', 'making', 'making', NULL, NULL);
INSERT INTO de_thi_anh (maDe, cau, noiDungCauHoi, A, B, C, D, dapAnDung, loiGiai, dapAnChon) VALUES ('anh1', 1, 'We are able to advise people what their legal ___________ are.', 'conscience  ', 'entitlement', 'decision', 'judge', 'entitlement', NULL, NULL);

-- Table: de_thi_dia
DROP TABLE IF EXISTS de_thi_dia;

CREATE TABLE de_thi_dia (
    maDe          STRING  REFERENCES ma_de (maDe) ON DELETE NO ACTION
                                                  ON UPDATE NO ACTION,
    cau           INTEGER NOT NULL,
    noiDungCauHoi TEXT    NOT NULL,
    A             TEXT    NOT NULL,
    B             TEXT    NOT NULL,
    C             TEXT    NOT NULL,
    D             TEXT    NOT NULL,
    dapAnDung     TEXT    NOT NULL,
    loiGiai       TEXT,
    dapAnChon     TEXT
);

INSERT INTO de_thi_dia (maDe, cau, noiDungCauHoi, A, B, C, D, dapAnDung, loiGiai, dapAnChon) VALUES ('dia1', 5, 'Ð?nh hu?ng nào không ph?i là bi?n pháp d?y m?nh công cu?c Ð?i m?i và h?i nh?p c?a nu?c ta?', 'Tang tru?ng xóa dói gi?m nghèo.', 'Ð?y m?nh công nghi?p hóa – hi?n d?i hóa.', 'Phát tri?n n?n kinh t? hàng hoá nhi?u thành ph?n.', 'B?o v? tài nguyên, môi tru?ng và phát tri?n b?n v?ng.', 'Phát tri?n n?n kinh t? hàng hoá nhi?u thành ph?n.', NULL, NULL);
INSERT INTO de_thi_dia (maDe, cau, noiDungCauHoi, A, B, C, D, dapAnDung, loiGiai, dapAnChon) VALUES ('dia1', 4, 'M?c tiêu c?a công cu?c d?i m?i kinh t? xã h?i ? nu?c ta là', 'd?ng b? th? ch? kinh t? th? tru?ng.', 'd?y m?nh các h?p tác xã phát tri?n.', 'phát tri?n n?n kinh t? nhi?u thành ph?n.', 'h?n ch? tham gia các t? ch?c trên th? gi?i', 'd?ng b? th? ch? kinh t? th? tru?ng.', NULL, NULL);
INSERT INTO de_thi_dia (maDe, cau, noiDungCauHoi, A, B, C, D, dapAnDung, loiGiai, dapAnChon) VALUES ('dia1', 3, 'Công cu?c Ð?i m?i c?a nu?c ta không di?n ra theo xu th? nào sau dây?', 'Phát tri?n n?n kinh t? th? tru?ng tu b?n ch? nghia.', 'Dân ch? hoá d?i s?ng kinh t? - xã h?i.', 'Phát tri?n n?n kinh t? hàng hoá nhi?u thành ph?n d?nh hu?ng XHCN.', 'Tang cu?ng giao luu và h?p tác v?i các nu?c trên th? gi?i.', 'Phát tri?n n?n kinh t? th? tru?ng tu b?n ch? nghia.', NULL, NULL);
INSERT INTO de_thi_dia (maDe, cau, noiDungCauHoi, A, B, C, D, dapAnDung, loiGiai, dapAnChon) VALUES ('dia1', 2, 'Nu?c ta thoát kh?i tình tr?ng kh?ng ho?ng do', 'dân ch? hóa d?i s?ng kinh t? – xã h?i c?a các dân t?c', 'phát tri?n kinh t? d?ng d?u gi?a các dân t?c ? Vi?t Nam.', 'th?c hi?n d?i m?i kinh t? xã h?i t? nh?ng nam 1986', 'kh?c ph?c du?c h?u qu? c?a chi?n tranh Pháp - Mi', 'th?c hi?n d?i m?i kinh t? xã h?i t? nh?ng nam 1986', NULL, NULL);
INSERT INTO de_thi_dia (maDe, cau, noiDungCauHoi, A, B, C, D, dapAnDung, loiGiai, dapAnChon) VALUES ('dia1', 1, 'Phát tri?n n?n kinh t? hàng hóa nhi?u thành ph?n theo d?nh hu?ng xã h?i ch? nghia b?t d?u t?', 'khi nu?c ta dành d?c l?p nam 1945', 'sau khi kháng chi?n ch?ng Pháp thành công nam 1954', 'công cu?c d?i m?i kinh t? - xã h?i nam 1986', 'sau khi nu?c ta gia nh?p ASEAN 1995 và WTO 2007', 'công cu?c d?i m?i kinh t? - xã h?i nam 1986', NULL, NULL);

-- Table: de_thi_gdcd
DROP TABLE IF EXISTS de_thi_gdcd;

CREATE TABLE de_thi_gdcd (
    maDe          STRING  REFERENCES ma_de (maDe) ON DELETE NO ACTION
                                                  ON UPDATE NO ACTION,
    cau           INTEGER NOT NULL,
    noiDungCauHoi TEXT    NOT NULL,
    A             TEXT    NOT NULL,
    B             TEXT    NOT NULL,
    C             TEXT    NOT NULL,
    D             TEXT    NOT NULL,
    dapAnDung     TEXT    NOT NULL,
    loiGiai       TEXT,
    dapAnChon     TEXT
);

INSERT INTO de_thi_gdcd (maDe, cau, noiDungCauHoi, A, B, C, D, dapAnDung, loiGiai, dapAnChon) VALUES ('gdcd1', 5, 'N?i dung nào du?i dây không thu?c n?i dung công dân bình d?ng v? quy?n và nghia v??', 'Công dân bình d?ng v? nghia v? b?o v? T? qu?c.', 'Công dân bình d?ng v? nghia v? dóng góp vào qu? t? thi?n.', 'Công dân bình d?ng v? nghia v? dóng thu?.', 'Công dân bình d?ng v? quy?n b?u c?.', 'Công dân bình d?ng v? nghia v? dóng góp vào qu? t? thi?n.', NULL, NULL);
INSERT INTO de_thi_gdcd (maDe, cau, noiDungCauHoi, A, B, C, D, dapAnDung, loiGiai, dapAnChon) VALUES ('gdcd1', 4, 'M?i công dân khi có d? di?u ki?n theo quy d?nh c?a pháp lu?t d?u có quy?n kinh doanh là th? hi?n công dân bình d?ng', 'trong s?n xu?t.', 'trong kinh t?.', 'v? quy?n và nghia v?.', 'v? di?u ki?n kinh doanh.', 'v? quy?n và nghia v?.', NULL, NULL);
INSERT INTO de_thi_gdcd (maDe, cau, noiDungCauHoi, A, B, C, D, dapAnDung, loiGiai, dapAnChon) VALUES ('gdcd1', 3, 'Quy?n và nghia v? công dân không b? phân bi?t b?i dân t?c, gi?i tính và d?a v? xã h?i là th? hi?n quy?n bình d?ng nào du?i dây c?a công dân?', 'Bình d?ng v? thành ph?n xã h?i.', 'Bình d?ng quy?n và nghia v?.', ' Bình d?ng tôn giáo.', 'Bình d?ng dân t?c.', 'Bình d?ng quy?n và nghia v?.', NULL, NULL);
INSERT INTO de_thi_gdcd (maDe, cau, noiDungCauHoi, A, B, C, D, dapAnDung, loiGiai, dapAnChon) VALUES ('gdcd1', 2, 'B?t kì công dân nào vi ph?m pháp lu?t d?u ph?i b? x? lý theo quy d?nh c?a pháp lu?t là th? hi?n bình d?ng v?', 'trách nhi?m pháp lý', 'quy?n và nghia v?.', 'th?c hi?n pháp lu?t', 'trách nhi?m tru?c Tòa án', 'trách nhi?m pháp lý', NULL, NULL);
INSERT INTO de_thi_gdcd (maDe, cau, noiDungCauHoi, A, B, C, D, dapAnDung, loiGiai, dapAnChon) VALUES ('gdcd1', 1, 'M?i công dân d?u du?c hu?ng quy?n và ph?i th?c hi?n nghia v? theo quy d?nh c?a pháp lu?t là bi?u hi?n công dân bình d?ng v?', 'quy?n và nghia v?.', 'quy?n và trách nhi?m', 'nghia v? và trách nhi?m', 'trách nhi?m và pháp lý', 'quy?n và nghia v?.', NULL, NULL);

-- Table: de_thi_hoa
DROP TABLE IF EXISTS de_thi_hoa;

CREATE TABLE de_thi_hoa (
    maDe          STRING  REFERENCES ma_de (maDe) ON DELETE NO ACTION
                                                  ON UPDATE NO ACTION,
    cau           INTEGER NOT NULL,
    noiDungCauHoi TEXT    NOT NULL,
    A             TEXT    NOT NULL,
    B             TEXT    NOT NULL,
    C             TEXT    NOT NULL,
    D             TEXT    NOT NULL,
    dapAnDung     TEXT    NOT NULL,
    loiGiai       TEXT,
    dapAnChon     TEXT
);

INSERT INTO de_thi_hoa (maDe, cau, noiDungCauHoi, A, B, C, D, dapAnDung, loiGiai, dapAnChon) VALUES ('hoa1', 5, 'Trong các ch?t: este, axit, ancol có cùng s? nguyên t? cacbon thì ch?t có nhi?t d? sôi th?p nh?t là', 'Axit', 'Este', 'Ancol', 'Không so sánh du?c', 'Este', NULL, NULL);
INSERT INTO de_thi_hoa (maDe, cau, noiDungCauHoi, A, B, C, D, dapAnDung, loiGiai, dapAnChon) VALUES ('hoa1', 4, 'Công th?c t?ng quát c?a este no, don ch?c, m?ch h? là?', 'RCOOR’', 'CxHyOz', 'CnH2nO2', 'CnH2n-2 O2', 'CnH2nO2', NULL, NULL);
INSERT INTO de_thi_hoa (maDe, cau, noiDungCauHoi, A, B, C, D, dapAnDung, loiGiai, dapAnChon) VALUES ('hoa1', 3, 'Ðun nóng este 
HCOOCH
3
 v?i m?t lu?ng v?a d? dung d?ch NaOH, s?n ph?m thu du?c là', 'CH3COONa
và
C2H5OH', 'HCOONa và CH3OH', 'HCOOH và C2H5OH', 'CH3COONa và CH3OH', 'HCOONa và CH3OH', NULL, NULL);
INSERT INTO de_thi_hoa (maDe, cau, noiDungCauHoi, A, B, C, D, dapAnDung, loiGiai, dapAnChon) VALUES ('hoa1', 2, 'Este có mùi d?a là', '3', 'etyl butirat', 'etyl axetat', 'geranyl axetat', 'etyl butirat', NULL, NULL);
INSERT INTO de_thi_hoa (maDe, cau, noiDungCauHoi, A, B, C, D, dapAnDung, loiGiai, dapAnChon) VALUES ('hoa1', 1, '?ng v?i công th?c 
C4H8O2
 có bao nhiêu este là d?ng phân c?a nhau ? ', 'COONa', '3', '4', '5', '4', NULL, NULL);

-- Table: de_thi_li
DROP TABLE IF EXISTS de_thi_li;

CREATE TABLE de_thi_li (
    maDe          STRING  REFERENCES ma_de (maDe) ON DELETE NO ACTION
                                                  ON UPDATE NO ACTION,
    cau           INTEGER NOT NULL,
    noiDungCauHoi TEXT    NOT NULL,
    A             TEXT    NOT NULL,
    B             TEXT    NOT NULL,
    C             TEXT    NOT NULL,
    D             TEXT    NOT NULL,
    dapAnDung     TEXT    NOT NULL,
    loiGiai       TEXT,
    dapAnChon     TEXT
);

INSERT INTO de_thi_li (maDe, cau, noiDungCauHoi, A, B, C, D, dapAnDung, loiGiai, dapAnChon) VALUES ('li1', 5, 'M?t v?t dao d?ng di?u hoà d?c theo tr?c Ox v?i phuong trình:  N?u ch?n g?c to? d? O t?i v? trí cân b?ng c?a v?t thì g?c th?i gian t = 1s là lúc v?t:', '? v? trí li d? c?c d?i thu?c ph?n duong c?a tr?c Ox', 'Qua v? trí cân b?ng O ngu?c chi?u duong c?a tr?c Ox', ' ? v? trí li d? c?c d?i thu?c ph?n âm c?a tr?c Ox', 'Qua v? trí cân b?ng O theo chi?u duong c?a tr?c Ox', ' ? v? trí li d? c?c d?i thu?c ph?n âm c?a tr?c Ox', NULL, NULL);
INSERT INTO de_thi_li (maDe, cau, noiDungCauHoi, A, B, C, D, dapAnDung, loiGiai, dapAnChon) VALUES ('li1', 4, 'Ch?n phát bi?u dúng:', 'Quãng du?ng v?t di du?c trong m?t chu kì dao d?ng là 2A', 'Ð? d?i l?n nh?t c?a v?t trong quá trình dao d?ng là A', 'Ð? dài qu? d?o chuy?n d?ng c?a v?t là 4A', 'Quãng du?ng v?t di du?c trong n?a chu kì dao d?ng là 
A/2
', 'Ð? d?i l?n nh?t c?a v?t trong quá trình dao d?ng là A', NULL, NULL);
INSERT INTO de_thi_li (maDe, cau, noiDungCauHoi, A, B, C, D, dapAnDung, loiGiai, dapAnChon) VALUES ('li1', 3, 'Trong dao d?ng di?u hòa c?a m?t v?t thì t?p h?p 2 d?i lu?ng nào sau dây là không d?i theo th?i gian?', 'Biên d?, t?n s?.', 'Biên d?, gia t?c.', 'V?n t?c, t?n s?.', 'Li d?, v?n t?c.', 'Biên d?, t?n s?.', NULL, NULL);
INSERT INTO de_thi_li (maDe, cau, noiDungCauHoi, A, B, C, D, dapAnDung, loiGiai, dapAnChon) VALUES ('li1', 2, 'M?t v?t dao d?ng di?u hoà v?i chu kì T, biên d? b?ng 5 cm. Quãng du?ng v?t di du?c trong 2,5T là:', '10 cm', '50 cm', '45 cm', '25 cm', '50 cm', NULL, NULL);
INSERT INTO de_thi_li (maDe, cau, noiDungCauHoi, A, B, C, D, dapAnDung, loiGiai, dapAnChon) VALUES ('li1', 1, 'M?t ch?t di?m dao d?ng di?u hoà v?i chu kì 1,25 s và biên d? 5 cm. T?c d? l?n nh?t c?a ch?t di?m là:', '25,1 cm/s', '2,5 cm/s', ' 63,5 cm/s', '6,3 cm/s', '25,1 cm/s', NULL, NULL);

-- Table: de_thi_sinh
DROP TABLE IF EXISTS de_thi_sinh;

CREATE TABLE de_thi_sinh (
    maDe          STRING  REFERENCES ma_de (maDe) ON DELETE NO ACTION
                                                  ON UPDATE NO ACTION,
    cau           INTEGER NOT NULL,
    noiDungCauHoi TEXT    NOT NULL,
    A             TEXT    NOT NULL,
    B             TEXT    NOT NULL,
    C             TEXT    NOT NULL,
    D             TEXT    NOT NULL,
    dapAnDung     TEXT    NOT NULL,
    loiGiai       TEXT,
    dapAnChon     TEXT
);

INSERT INTO de_thi_sinh (maDe, cau, noiDungCauHoi, A, B, C, D, dapAnDung, loiGiai, dapAnChon) VALUES ('sinh1', 5, 'Tính d?c hi?u c?a mã di truy?n du?c th? hi?n nhu th? nào?', 'M?i loài sinh v?t d?u có chung m?t b? mã di truy?n', 'M?i axit amin thu?ng du?c mã hóa b?i nhi?u b? ba.', ' M?i b? ba ch? mã hóa cho m?t lo?i axit amin', 'Mã di truy?n du?c d?c theo c?m n?i ti?p, không g?i nhau.', ' M?i b? ba ch? mã hóa cho m?t lo?i axit amin', NULL, NULL);
INSERT INTO de_thi_sinh (maDe, cau, noiDungCauHoi, A, B, C, D, dapAnDung, loiGiai, dapAnChon) VALUES ('sinh1', 4, 'Tính thoái hóa c?a mã di truy?n là hi?n tu?ng nhi?u b? ba khác nhau cùng mã hóa cho m?t lo?i axit amin. Nh?ng mã di truy?n nào sau dây có tính thoái hóa?', '5’AUG3’, 5’UGG3’', '5’XAG3’, 5’AUG3’', '5’UUU3’, 5’AUG3’', '5’UXG3’. 5’AGX3’', '5’AUG3’, 5’UGG3’', NULL, NULL);
INSERT INTO de_thi_sinh (maDe, cau, noiDungCauHoi, A, B, C, D, dapAnDung, loiGiai, dapAnChon) VALUES ('sinh1', 3, 'Phát bi?u nào sau dây không dúng khi nói v? NST trong t? bào sinh du?ng c?a các loài?', 'M?i loài có b? NST d?c trung v? s? lu?ng, hình thái và c?u trúc.', 'NST thu?ng bao gi? cung t?n t?o thành t?ng c?p tuong d?ng và có s? lu?ng nhi?u hon NST gi?i tính.', ' NST gi?i tính ch? có m?t c?p có th? tuong d?ng ho?c không tuong d?ng, ? m?t s? loài NST gi?i tính ch? có m?t chi?c.', 'C?p NST gi?i tính ? gi?i cái bao gi? cung g?m 2 chi?c có th? tuong d?ng ho?c không tuong d?ng', 'C?p NST gi?i tính ? gi?i cái bao gi? cung g?m 2 chi?c có th? tuong d?ng ho?c không tuong d?ng', NULL, NULL);
INSERT INTO de_thi_sinh (maDe, cau, noiDungCauHoi, A, B, C, D, dapAnDung, loiGiai, dapAnChon) VALUES ('sinh1', 2, 'Trong c?u trúc siêu hi?n vi c?a NST nhân th?c, s?i co b?n có du?ng kính b?ng', '2nm', '11nm', '20nm', '32nm', '11nm', NULL, NULL);
INSERT INTO de_thi_sinh (maDe, cau, noiDungCauHoi, A, B, C, D, dapAnDung, loiGiai, dapAnChon) VALUES ('sinh1', 1, 'C?u trúc c?a m?t nucleoxom g?m', ' m?t do?n phân t? ADN qu?n 11/4 vòng quanh kh?i c?u g?m 8 phân t? histon', 'phân t? ADN qu?n 7/4 vòng quanh kh?i c?u g?m 8 phân t? histon', 'phân t? histon du?c qu?n quanh b?i 1 do?n ADN dài 146 nucleotit', '8 phân t? histon du?c qu?n quanh b?i 7/4 vòng xo?n ADN dài 146 c?p nucleotit', '8 phân t? histon du?c qu?n quanh b?i 7/4 vòng xo?n ADN dài 146 c?p nucleotit', NULL, NULL);

-- Table: de_thi_su
DROP TABLE IF EXISTS de_thi_su;

CREATE TABLE de_thi_su (
    maDe          STRING  REFERENCES ma_de (maDe) ON DELETE NO ACTION
                                                  ON UPDATE NO ACTION,
    cau           INTEGER NOT NULL,
    noiDungCauHoi TEXT    NOT NULL,
    A             TEXT    NOT NULL,
    B             TEXT    NOT NULL,
    C             TEXT    NOT NULL,
    D             TEXT    NOT NULL,
    dapAnDung     TEXT    NOT NULL,
    loiGiai       TEXT,
    dapAnChon     TEXT
);

INSERT INTO de_thi_su (maDe, cau, noiDungCauHoi, A, B, C, D, dapAnDung, loiGiai, dapAnChon) VALUES ('su1', 5, 'Nam 1965, Mi b?t d?u ti?n hành chi?n lu?c Chi?n tranh c?c b? ? mi?n Nam Vi?t Nam khi dang', 'b? th?t b?i trên chi?n tru?ng.  ', '? th? ch? d?ng chi?n lu?c', 'n?m gi? uu th? v? binh l?c và h?a l?c', 'giành du?c nhi?u th?ng l?i quan tr?ng.', 'b? th?t b?i trên chi?n tru?ng.  ', NULL, NULL);
INSERT INTO de_thi_su (maDe, cau, noiDungCauHoi, A, B, C, D, dapAnDung, loiGiai, dapAnChon) VALUES ('su1', 4, 'V?n d? ru?ng d?t cho dân cày dã du?c kh?ng d?nh l?n d?u tiên trong van ki?n nào c?a Ð?ng?  ', 'Cuong linh chính tr? d?u tiên c?a Ð?ng C?ng s?n Vi?t Nam.', 'Lu?n cuong chính tr? c?a Ð?ng C?ng s?n Ðông Duong.', 'Ngh? quy?t h?i ngh? Ban Ch?p hành trung uong Ð?ng tháng 10/1930. ', 'Ngh? quy?t Ð?i h?i Ð?ng toàn qu?c l?n th? I (3/1935).', 'Cuong linh chính tr? d?u tiên c?a Ð?ng C?ng s?n Vi?t Nam.', NULL, NULL);
INSERT INTO de_thi_su (maDe, cau, noiDungCauHoi, A, B, C, D, dapAnDung, loiGiai, dapAnChon) VALUES ('su1', 3, 'Sau khi cu?c kháng chi?n ch?ng Pháp k?t thúc, mi?n B?c Vi?t Nam dã can b?n hoàn thành cu?c cách m?ng nào?', 'Cách m?ng ru?ng d?t.', 'Cách m?ng dân ch? tu s?n ki?u m?i.', 'Cách m?ng vô s?n. ', 'Cách m?ng dân t?c dân ch? nhân dân.', 'Cách m?ng dân t?c dân ch? nhân dân.', NULL, NULL);
INSERT INTO de_thi_su (maDe, cau, noiDungCauHoi, A, B, C, D, dapAnDung, loiGiai, dapAnChon) VALUES ('su1', 2, 'Th?c dân Pháp rút quân kh?i mi?n Nam Vi?t Nam (tháng 5/1956) khi', 't?t c? m?i di?u kho?n trong Hi?p d?nh Gionevo dã du?c th?c thi.', 'chua th?c hi?n cu?c hi?p thuong t?ng tuy?n c? th?ng nh?t Vi?t Nam', 'k?t thúc cu?c hi?p thuong t?ng tuy?n c? th?ng nh?t Vi?t Nam', 'Mi d?ng lên chính quy?n tay sai Nguy?n Van Thi?u ? mi?n Nam Vi?t Nam', 'chua th?c hi?n cu?c hi?p thuong t?ng tuy?n c? th?ng nh?t Vi?t Nam', NULL, NULL);
INSERT INTO de_thi_su (maDe, cau, noiDungCauHoi, A, B, C, D, dapAnDung, loiGiai, dapAnChon) VALUES ('su1', 1, 'Ngày 10/10/1954 di?n ra s? ki?n l?ch s? nào du?i dây?', 'Mi?n B?c Vi?t Nam hoàn toàn gi?i phóng kh?i ách cai tr? c?a th?c dân Pháp.', 'Trung uong Ð?ng, Chính ph? và Ch? t?ch H? Chí Minh ra m?t nhân dân Th? dô.', 'Quân d?i nhân dân Vi?t Nam ti?n vào ti?p qu?n Th? dô Hà N?i.', 'Tên lính Pháp cu?i cùng rút kh?i Vi?t Nam.', 'Quân d?i nhân dân Vi?t Nam ti?n vào ti?p qu?n Th? dô Hà N?i.', NULL, NULL);

-- Table: de_thi_toan
DROP TABLE IF EXISTS de_thi_toan;

CREATE TABLE de_thi_toan (
    maDe          STRING  REFERENCES ma_de (maDe) ON DELETE NO ACTION
                                                  ON UPDATE NO ACTION,
    cau           INTEGER NOT NULL,
    noiDungCauHoi TEXT    NOT NULL,
    A             TEXT    NOT NULL,
    B             TEXT    NOT NULL,
    C             TEXT    NOT NULL,
    D             TEXT    NOT NULL,
    dapAnDung     TEXT    NOT NULL,
    loiGiai       TEXT,
    dapAnChon     TEXT
);

INSERT INTO de_thi_toan (maDe, cau, noiDungCauHoi, A, B, C, D, dapAnDung, loiGiai, dapAnChon) VALUES ('toan1', 5, 'Tìm s? c?nh c?a hình mu?i hai m?t d?u.', '20', '12', '30', '16', '30', 'Lý thuy?t SGK: 12', NULL);
INSERT INTO de_thi_toan (maDe, cau, noiDungCauHoi, A, B, C, D, dapAnDung, loiGiai, dapAnChon) VALUES ('toan1', 4, 'Cho m?t hình da di?n. Kh?ng d?nh nào sau dây sai?', 'M?i c?nh là c?nh chung c?a ít nh?t ba m?t', 'M?i d?nh là d?nh chung c?a ít nh?t ba c?nh', ' M?i d?nh là d?nh chung c?a ít nh?t ba m?t', 'M?i m?t có ít nh?t ba c?nh', 'M?i c?nh là c?nh chung c?a ít nh?t ba m?t', NULL, NULL);
INSERT INTO de_thi_toan (maDe, cau, noiDungCauHoi, A, B, C, D, dapAnDung, loiGiai, dapAnChon) VALUES ('toan1', 3, 'M?i d?nh c?a m?t hình da di?n là d?nh chung c?a ít nh?t', 'Nam c?nh', 'B?n c?nh', 'Ba c?nh', 'Hai C?nh', 'Ba c?nh', NULL, NULL);
INSERT INTO de_thi_toan (maDe, cau, noiDungCauHoi, A, B, C, D, dapAnDung, loiGiai, dapAnChon) VALUES ('toan1', 2, 'Cho t? di?n ABCD có th? tích b?ng 12 và G là tr?ng tâm c?a tam giác BCD Tính th? tích V c?a kh?i chóp A.GBC', 'V = 6', 'V = 4', 'V = 5', 'V = 3', 'V = 4', NULL, NULL);
INSERT INTO de_thi_toan (maDe, cau, noiDungCauHoi, A, B, C, D, dapAnDung, loiGiai, dapAnChon) VALUES ('toan1', 1, 'Trong không gian v?i h? tr?c t?a d? Oxyz, cho m?t ph?ng (P) 2x+y-1=0. M?t ph?ng (P) có 1 vecto pháp tuy?n là ', ' (-2;-2;1)', '(2;1;-1)', '(1;2;0)', '(2;1;0)', '(2;1;0)', NULL, NULL);

-- Table: ma_de
DROP TABLE IF EXISTS ma_de;

CREATE TABLE ma_de (
    maDe      STRING  PRIMARY KEY,
    soCau     INTEGER NOT NULL,
    thoiGian  INTEGER NOT NULL,
    tinhTrang BOOLEAN NOT NULL,
    maMonHoc  STRING  REFERENCES mon_hoc (maMon) ON DELETE SET NULL
                                                 ON UPDATE NO ACTION,
    diem      DOUBLE
);

INSERT INTO ma_de (maDe, soCau, thoiGian, tinhTrang, maMonHoc, diem) VALUES ('hoa1', 5, 20, 'Chua Làm', 'hoa', NULL);
INSERT INTO ma_de (maDe, soCau, thoiGian, tinhTrang, maMonHoc, diem) VALUES ('li1', 5, 20, 'Chua Làm', 'li', NULL);
INSERT INTO ma_de (maDe, soCau, thoiGian, tinhTrang, maMonHoc, diem) VALUES ('toan1', 5, 20, 'Chua Làm', 'toan', NULL);
INSERT INTO ma_de (maDe, soCau, thoiGian, tinhTrang, maMonHoc, diem) VALUES ('su1', 5, 20, 'Chua Làm', 'su', NULL);
INSERT INTO ma_de (maDe, soCau, thoiGian, tinhTrang, maMonHoc, diem) VALUES ('anh1', 5, 20, 'Chua Làm', 'anh', NULL);
INSERT INTO ma_de (maDe, soCau, thoiGian, tinhTrang, maMonHoc, diem) VALUES ('sinh1', 5, 20, 'Chua Làm', 'sinh', NULL);
INSERT INTO ma_de (maDe, soCau, thoiGian, tinhTrang, maMonHoc, diem) VALUES ('gdcd1', 5, 20, 'Chua Làm', 'gdcd', NULL);
INSERT INTO ma_de (maDe, soCau, thoiGian, tinhTrang, maMonHoc, diem) VALUES ('dia1', 5, 20, 'Chua Làm', 'dia', NULL);

-- Table: mon_hoc
DROP TABLE IF EXISTS mon_hoc;

CREATE TABLE mon_hoc (
    maMon  STRING  PRIMARY KEY,
    tenMon STRING,
    tongDe INTEGER
);

INSERT INTO mon_hoc (maMon, tenMon, tongDe) VALUES ('gdcd', 'Giáo D?c Công Dân', 1);
INSERT INTO mon_hoc (maMon, tenMon, tongDe) VALUES ('dia', 'Ð?a Lí', 1);
INSERT INTO mon_hoc (maMon, tenMon, tongDe) VALUES ('su', 'L?ch S?', 1);
INSERT INTO mon_hoc (maMon, tenMon, tongDe) VALUES ('sinh', 'Sinh H?c', 1);
INSERT INTO mon_hoc (maMon, tenMon, tongDe) VALUES ('hoa', 'Hóa H?c', 1);
INSERT INTO mon_hoc (maMon, tenMon, tongDe) VALUES ('li', 'V?t Lí', 1);
INSERT INTO mon_hoc (maMon, tenMon, tongDe) VALUES ('anh', 'Ti?ng Anh', 1);
INSERT INTO mon_hoc (maMon, tenMon, tongDe) VALUES ('toan', 'Toán', 1);

COMMIT TRANSACTION;
PRAGMA foreign_keys = on;
