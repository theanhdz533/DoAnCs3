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

INSERT INTO de_thi_dia (maDe, cau, noiDungCauHoi, A, B, C, D, dapAnDung, loiGiai, dapAnChon) VALUES ('dia1', 5, '�?nh hu?ng n�o kh�ng ph?i l� bi?n ph�p d?y m?nh c�ng cu?c �?i m?i v� h?i nh?p c?a nu?c ta?', 'Tang tru?ng x�a d�i gi?m ngh�o.', '�?y m?nh c�ng nghi?p h�a � hi?n d?i h�a.', 'Ph�t tri?n n?n kinh t? h�ng ho� nhi?u th�nh ph?n.', 'B?o v? t�i nguy�n, m�i tru?ng v� ph�t tri?n b?n v?ng.', 'Ph�t tri?n n?n kinh t? h�ng ho� nhi?u th�nh ph?n.', NULL, NULL);
INSERT INTO de_thi_dia (maDe, cau, noiDungCauHoi, A, B, C, D, dapAnDung, loiGiai, dapAnChon) VALUES ('dia1', 4, 'M?c ti�u c?a c�ng cu?c d?i m?i kinh t? x� h?i ? nu?c ta l�', 'd?ng b? th? ch? kinh t? th? tru?ng.', 'd?y m?nh c�c h?p t�c x� ph�t tri?n.', 'ph�t tri?n n?n kinh t? nhi?u th�nh ph?n.', 'h?n ch? tham gia c�c t? ch?c tr�n th? gi?i', 'd?ng b? th? ch? kinh t? th? tru?ng.', NULL, NULL);
INSERT INTO de_thi_dia (maDe, cau, noiDungCauHoi, A, B, C, D, dapAnDung, loiGiai, dapAnChon) VALUES ('dia1', 3, 'C�ng cu?c �?i m?i c?a nu?c ta kh�ng di?n ra theo xu th? n�o sau d�y?', 'Ph�t tri?n n?n kinh t? th? tru?ng tu b?n ch? nghia.', 'D�n ch? ho� d?i s?ng kinh t? - x� h?i.', 'Ph�t tri?n n?n kinh t? h�ng ho� nhi?u th�nh ph?n d?nh hu?ng XHCN.', 'Tang cu?ng giao luu v� h?p t�c v?i c�c nu?c tr�n th? gi?i.', 'Ph�t tri?n n?n kinh t? th? tru?ng tu b?n ch? nghia.', NULL, NULL);
INSERT INTO de_thi_dia (maDe, cau, noiDungCauHoi, A, B, C, D, dapAnDung, loiGiai, dapAnChon) VALUES ('dia1', 2, 'Nu?c ta tho�t kh?i t�nh tr?ng kh?ng ho?ng do', 'd�n ch? h�a d?i s?ng kinh t? � x� h?i c?a c�c d�n t?c', 'ph�t tri?n kinh t? d?ng d?u gi?a c�c d�n t?c ? Vi?t Nam.', 'th?c hi?n d?i m?i kinh t? x� h?i t? nh?ng nam 1986', 'kh?c ph?c du?c h?u qu? c?a chi?n tranh Ph�p - Mi', 'th?c hi?n d?i m?i kinh t? x� h?i t? nh?ng nam 1986', NULL, NULL);
INSERT INTO de_thi_dia (maDe, cau, noiDungCauHoi, A, B, C, D, dapAnDung, loiGiai, dapAnChon) VALUES ('dia1', 1, 'Ph�t tri?n n?n kinh t? h�ng h�a nhi?u th�nh ph?n theo d?nh hu?ng x� h?i ch? nghia b?t d?u t?', 'khi nu?c ta d�nh d?c l?p nam 1945', 'sau khi kh�ng chi?n ch?ng Ph�p th�nh c�ng nam 1954', 'c�ng cu?c d?i m?i kinh t? - x� h?i nam 1986', 'sau khi nu?c ta gia nh?p ASEAN 1995 v� WTO 2007', 'c�ng cu?c d?i m?i kinh t? - x� h?i nam 1986', NULL, NULL);

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

INSERT INTO de_thi_gdcd (maDe, cau, noiDungCauHoi, A, B, C, D, dapAnDung, loiGiai, dapAnChon) VALUES ('gdcd1', 5, 'N?i dung n�o du?i d�y kh�ng thu?c n?i dung c�ng d�n b�nh d?ng v? quy?n v� nghia v??', 'C�ng d�n b�nh d?ng v? nghia v? b?o v? T? qu?c.', 'C�ng d�n b�nh d?ng v? nghia v? d�ng g�p v�o qu? t? thi?n.', 'C�ng d�n b�nh d?ng v? nghia v? d�ng thu?.', 'C�ng d�n b�nh d?ng v? quy?n b?u c?.', 'C�ng d�n b�nh d?ng v? nghia v? d�ng g�p v�o qu? t? thi?n.', NULL, NULL);
INSERT INTO de_thi_gdcd (maDe, cau, noiDungCauHoi, A, B, C, D, dapAnDung, loiGiai, dapAnChon) VALUES ('gdcd1', 4, 'M?i c�ng d�n khi c� d? di?u ki?n theo quy d?nh c?a ph�p lu?t d?u c� quy?n kinh doanh l� th? hi?n c�ng d�n b�nh d?ng', 'trong s?n xu?t.', 'trong kinh t?.', 'v? quy?n v� nghia v?.', 'v? di?u ki?n kinh doanh.', 'v? quy?n v� nghia v?.', NULL, NULL);
INSERT INTO de_thi_gdcd (maDe, cau, noiDungCauHoi, A, B, C, D, dapAnDung, loiGiai, dapAnChon) VALUES ('gdcd1', 3, 'Quy?n v� nghia v? c�ng d�n kh�ng b? ph�n bi?t b?i d�n t?c, gi?i t�nh v� d?a v? x� h?i l� th? hi?n quy?n b�nh d?ng n�o du?i d�y c?a c�ng d�n?', 'B�nh d?ng v? th�nh ph?n x� h?i.', 'B�nh d?ng quy?n v� nghia v?.', ' B�nh d?ng t�n gi�o.', 'B�nh d?ng d�n t?c.', 'B�nh d?ng quy?n v� nghia v?.', NULL, NULL);
INSERT INTO de_thi_gdcd (maDe, cau, noiDungCauHoi, A, B, C, D, dapAnDung, loiGiai, dapAnChon) VALUES ('gdcd1', 2, 'B?t k� c�ng d�n n�o vi ph?m ph�p lu?t d?u ph?i b? x? l� theo quy d?nh c?a ph�p lu?t l� th? hi?n b�nh d?ng v?', 'tr�ch nhi?m ph�p l�', 'quy?n v� nghia v?.', 'th?c hi?n ph�p lu?t', 'tr�ch nhi?m tru?c T�a �n', 'tr�ch nhi?m ph�p l�', NULL, NULL);
INSERT INTO de_thi_gdcd (maDe, cau, noiDungCauHoi, A, B, C, D, dapAnDung, loiGiai, dapAnChon) VALUES ('gdcd1', 1, 'M?i c�ng d�n d?u du?c hu?ng quy?n v� ph?i th?c hi?n nghia v? theo quy d?nh c?a ph�p lu?t l� bi?u hi?n c�ng d�n b�nh d?ng v?', 'quy?n v� nghia v?.', 'quy?n v� tr�ch nhi?m', 'nghia v? v� tr�ch nhi?m', 'tr�ch nhi?m v� ph�p l�', 'quy?n v� nghia v?.', NULL, NULL);

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

INSERT INTO de_thi_hoa (maDe, cau, noiDungCauHoi, A, B, C, D, dapAnDung, loiGiai, dapAnChon) VALUES ('hoa1', 5, 'Trong c�c ch?t: este, axit, ancol c� c�ng s? nguy�n t? cacbon th� ch?t c� nhi?t d? s�i th?p nh?t l�', 'Axit', 'Este', 'Ancol', 'Kh�ng so s�nh du?c', 'Este', NULL, NULL);
INSERT INTO de_thi_hoa (maDe, cau, noiDungCauHoi, A, B, C, D, dapAnDung, loiGiai, dapAnChon) VALUES ('hoa1', 4, 'C�ng th?c t?ng qu�t c?a este no, don ch?c, m?ch h? l�?', 'RCOOR�', 'CxHyOz', 'CnH2nO2', 'CnH2n-2 O2', 'CnH2nO2', NULL, NULL);
INSERT INTO de_thi_hoa (maDe, cau, noiDungCauHoi, A, B, C, D, dapAnDung, loiGiai, dapAnChon) VALUES ('hoa1', 3, '�un n�ng este 
HCOOCH
3
 v?i m?t lu?ng v?a d? dung d?ch NaOH, s?n ph?m thu du?c l�', 'CH3COONa
v�
C2H5OH', 'HCOONa v� CH3OH', 'HCOOH v� C2H5OH', 'CH3COONa v� CH3OH', 'HCOONa v� CH3OH', NULL, NULL);
INSERT INTO de_thi_hoa (maDe, cau, noiDungCauHoi, A, B, C, D, dapAnDung, loiGiai, dapAnChon) VALUES ('hoa1', 2, 'Este c� m�i d?a l�', '3', 'etyl butirat', 'etyl axetat', 'geranyl axetat', 'etyl butirat', NULL, NULL);
INSERT INTO de_thi_hoa (maDe, cau, noiDungCauHoi, A, B, C, D, dapAnDung, loiGiai, dapAnChon) VALUES ('hoa1', 1, '?ng v?i c�ng th?c 
C4H8O2
 c� bao nhi�u este l� d?ng ph�n c?a nhau ? ', 'COONa', '3', '4', '5', '4', NULL, NULL);

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

INSERT INTO de_thi_li (maDe, cau, noiDungCauHoi, A, B, C, D, dapAnDung, loiGiai, dapAnChon) VALUES ('li1', 5, 'M?t v?t dao d?ng di?u ho� d?c theo tr?c Ox v?i phuong tr�nh:  N?u ch?n g?c to? d? O t?i v? tr� c�n b?ng c?a v?t th� g?c th?i gian t = 1s l� l�c v?t:', '? v? tr� li d? c?c d?i thu?c ph?n duong c?a tr?c Ox', 'Qua v? tr� c�n b?ng O ngu?c chi?u duong c?a tr?c Ox', ' ? v? tr� li d? c?c d?i thu?c ph?n �m c?a tr?c Ox', 'Qua v? tr� c�n b?ng O theo chi?u duong c?a tr?c Ox', ' ? v? tr� li d? c?c d?i thu?c ph?n �m c?a tr?c Ox', NULL, NULL);
INSERT INTO de_thi_li (maDe, cau, noiDungCauHoi, A, B, C, D, dapAnDung, loiGiai, dapAnChon) VALUES ('li1', 4, 'Ch?n ph�t bi?u d�ng:', 'Qu�ng du?ng v?t di du?c trong m?t chu k� dao d?ng l� 2A', '�? d?i l?n nh?t c?a v?t trong qu� tr�nh dao d?ng l� A', '�? d�i qu? d?o chuy?n d?ng c?a v?t l� 4A', 'Qu�ng du?ng v?t di du?c trong n?a chu k� dao d?ng l� 
A/2
', '�? d?i l?n nh?t c?a v?t trong qu� tr�nh dao d?ng l� A', NULL, NULL);
INSERT INTO de_thi_li (maDe, cau, noiDungCauHoi, A, B, C, D, dapAnDung, loiGiai, dapAnChon) VALUES ('li1', 3, 'Trong dao d?ng di?u h�a c?a m?t v?t th� t?p h?p 2 d?i lu?ng n�o sau d�y l� kh�ng d?i theo th?i gian?', 'Bi�n d?, t?n s?.', 'Bi�n d?, gia t?c.', 'V?n t?c, t?n s?.', 'Li d?, v?n t?c.', 'Bi�n d?, t?n s?.', NULL, NULL);
INSERT INTO de_thi_li (maDe, cau, noiDungCauHoi, A, B, C, D, dapAnDung, loiGiai, dapAnChon) VALUES ('li1', 2, 'M?t v?t dao d?ng di?u ho� v?i chu k� T, bi�n d? b?ng 5 cm. Qu�ng du?ng v?t di du?c trong 2,5T l�:', '10 cm', '50 cm', '45 cm', '25 cm', '50 cm', NULL, NULL);
INSERT INTO de_thi_li (maDe, cau, noiDungCauHoi, A, B, C, D, dapAnDung, loiGiai, dapAnChon) VALUES ('li1', 1, 'M?t ch?t di?m dao d?ng di?u ho� v?i chu k� 1,25 s v� bi�n d? 5 cm. T?c d? l?n nh?t c?a ch?t di?m l�:', '25,1 cm/s', '2,5 cm/s', ' 63,5 cm/s', '6,3 cm/s', '25,1 cm/s', NULL, NULL);

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

INSERT INTO de_thi_sinh (maDe, cau, noiDungCauHoi, A, B, C, D, dapAnDung, loiGiai, dapAnChon) VALUES ('sinh1', 5, 'T�nh d?c hi?u c?a m� di truy?n du?c th? hi?n nhu th? n�o?', 'M?i lo�i sinh v?t d?u c� chung m?t b? m� di truy?n', 'M?i axit amin thu?ng du?c m� h�a b?i nhi?u b? ba.', ' M?i b? ba ch? m� h�a cho m?t lo?i axit amin', 'M� di truy?n du?c d?c theo c?m n?i ti?p, kh�ng g?i nhau.', ' M?i b? ba ch? m� h�a cho m?t lo?i axit amin', NULL, NULL);
INSERT INTO de_thi_sinh (maDe, cau, noiDungCauHoi, A, B, C, D, dapAnDung, loiGiai, dapAnChon) VALUES ('sinh1', 4, 'T�nh tho�i h�a c?a m� di truy?n l� hi?n tu?ng nhi?u b? ba kh�c nhau c�ng m� h�a cho m?t lo?i axit amin. Nh?ng m� di truy?n n�o sau d�y c� t�nh tho�i h�a?', '5�AUG3�, 5�UGG3�', '5�XAG3�, 5�AUG3�', '5�UUU3�, 5�AUG3�', '5�UXG3�. 5�AGX3�', '5�AUG3�, 5�UGG3�', NULL, NULL);
INSERT INTO de_thi_sinh (maDe, cau, noiDungCauHoi, A, B, C, D, dapAnDung, loiGiai, dapAnChon) VALUES ('sinh1', 3, 'Ph�t bi?u n�o sau d�y kh�ng d�ng khi n�i v? NST trong t? b�o sinh du?ng c?a c�c lo�i?', 'M?i lo�i c� b? NST d?c trung v? s? lu?ng, h�nh th�i v� c?u tr�c.', 'NST thu?ng bao gi? cung t?n t?o th�nh t?ng c?p tuong d?ng v� c� s? lu?ng nhi?u hon NST gi?i t�nh.', ' NST gi?i t�nh ch? c� m?t c?p c� th? tuong d?ng ho?c kh�ng tuong d?ng, ? m?t s? lo�i NST gi?i t�nh ch? c� m?t chi?c.', 'C?p NST gi?i t�nh ? gi?i c�i bao gi? cung g?m 2 chi?c c� th? tuong d?ng ho?c kh�ng tuong d?ng', 'C?p NST gi?i t�nh ? gi?i c�i bao gi? cung g?m 2 chi?c c� th? tuong d?ng ho?c kh�ng tuong d?ng', NULL, NULL);
INSERT INTO de_thi_sinh (maDe, cau, noiDungCauHoi, A, B, C, D, dapAnDung, loiGiai, dapAnChon) VALUES ('sinh1', 2, 'Trong c?u tr�c si�u hi?n vi c?a NST nh�n th?c, s?i co b?n c� du?ng k�nh b?ng', '2nm', '11nm', '20nm', '32nm', '11nm', NULL, NULL);
INSERT INTO de_thi_sinh (maDe, cau, noiDungCauHoi, A, B, C, D, dapAnDung, loiGiai, dapAnChon) VALUES ('sinh1', 1, 'C?u tr�c c?a m?t nucleoxom g?m', ' m?t do?n ph�n t? ADN qu?n 11/4 v�ng quanh kh?i c?u g?m 8 ph�n t? histon', 'ph�n t? ADN qu?n 7/4 v�ng quanh kh?i c?u g?m 8 ph�n t? histon', 'ph�n t? histon du?c qu?n quanh b?i 1 do?n ADN d�i 146 nucleotit', '8 ph�n t? histon du?c qu?n quanh b?i 7/4 v�ng xo?n ADN d�i 146 c?p nucleotit', '8 ph�n t? histon du?c qu?n quanh b?i 7/4 v�ng xo?n ADN d�i 146 c?p nucleotit', NULL, NULL);

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

INSERT INTO de_thi_su (maDe, cau, noiDungCauHoi, A, B, C, D, dapAnDung, loiGiai, dapAnChon) VALUES ('su1', 5, 'Nam 1965, Mi b?t d?u ti?n h�nh chi?n lu?c Chi?n tranh c?c b? ? mi?n Nam Vi?t Nam khi dang', 'b? th?t b?i tr�n chi?n tru?ng.  ', '? th? ch? d?ng chi?n lu?c', 'n?m gi? uu th? v? binh l?c v� h?a l?c', 'gi�nh du?c nhi?u th?ng l?i quan tr?ng.', 'b? th?t b?i tr�n chi?n tru?ng.  ', NULL, NULL);
INSERT INTO de_thi_su (maDe, cau, noiDungCauHoi, A, B, C, D, dapAnDung, loiGiai, dapAnChon) VALUES ('su1', 4, 'V?n d? ru?ng d?t cho d�n c�y d� du?c kh?ng d?nh l?n d?u ti�n trong van ki?n n�o c?a �?ng?  ', 'Cuong linh ch�nh tr? d?u ti�n c?a �?ng C?ng s?n Vi?t Nam.', 'Lu?n cuong ch�nh tr? c?a �?ng C?ng s?n ��ng Duong.', 'Ngh? quy?t h?i ngh? Ban Ch?p h�nh trung uong �?ng th�ng 10/1930. ', 'Ngh? quy?t �?i h?i �?ng to�n qu?c l?n th? I (3/1935).', 'Cuong linh ch�nh tr? d?u ti�n c?a �?ng C?ng s?n Vi?t Nam.', NULL, NULL);
INSERT INTO de_thi_su (maDe, cau, noiDungCauHoi, A, B, C, D, dapAnDung, loiGiai, dapAnChon) VALUES ('su1', 3, 'Sau khi cu?c kh�ng chi?n ch?ng Ph�p k?t th�c, mi?n B?c Vi?t Nam d� can b?n ho�n th�nh cu?c c�ch m?ng n�o?', 'C�ch m?ng ru?ng d?t.', 'C�ch m?ng d�n ch? tu s?n ki?u m?i.', 'C�ch m?ng v� s?n. ', 'C�ch m?ng d�n t?c d�n ch? nh�n d�n.', 'C�ch m?ng d�n t?c d�n ch? nh�n d�n.', NULL, NULL);
INSERT INTO de_thi_su (maDe, cau, noiDungCauHoi, A, B, C, D, dapAnDung, loiGiai, dapAnChon) VALUES ('su1', 2, 'Th?c d�n Ph�p r�t qu�n kh?i mi?n Nam Vi?t Nam (th�ng 5/1956) khi', 't?t c? m?i di?u kho?n trong Hi?p d?nh Gionevo d� du?c th?c thi.', 'chua th?c hi?n cu?c hi?p thuong t?ng tuy?n c? th?ng nh?t Vi?t Nam', 'k?t th�c cu?c hi?p thuong t?ng tuy?n c? th?ng nh?t Vi?t Nam', 'Mi d?ng l�n ch�nh quy?n tay sai Nguy?n Van Thi?u ? mi?n Nam Vi?t Nam', 'chua th?c hi?n cu?c hi?p thuong t?ng tuy?n c? th?ng nh?t Vi?t Nam', NULL, NULL);
INSERT INTO de_thi_su (maDe, cau, noiDungCauHoi, A, B, C, D, dapAnDung, loiGiai, dapAnChon) VALUES ('su1', 1, 'Ng�y 10/10/1954 di?n ra s? ki?n l?ch s? n�o du?i d�y?', 'Mi?n B?c Vi?t Nam ho�n to�n gi?i ph�ng kh?i �ch cai tr? c?a th?c d�n Ph�p.', 'Trung uong �?ng, Ch�nh ph? v� Ch? t?ch H? Ch� Minh ra m?t nh�n d�n Th? d�.', 'Qu�n d?i nh�n d�n Vi?t Nam ti?n v�o ti?p qu?n Th? d� H� N?i.', 'T�n l�nh Ph�p cu?i c�ng r�t kh?i Vi?t Nam.', 'Qu�n d?i nh�n d�n Vi?t Nam ti?n v�o ti?p qu?n Th? d� H� N?i.', NULL, NULL);

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

INSERT INTO de_thi_toan (maDe, cau, noiDungCauHoi, A, B, C, D, dapAnDung, loiGiai, dapAnChon) VALUES ('toan1', 5, 'T�m s? c?nh c?a h�nh mu?i hai m?t d?u.', '20', '12', '30', '16', '30', 'L� thuy?t SGK: 12', NULL);
INSERT INTO de_thi_toan (maDe, cau, noiDungCauHoi, A, B, C, D, dapAnDung, loiGiai, dapAnChon) VALUES ('toan1', 4, 'Cho m?t h�nh da di?n. Kh?ng d?nh n�o sau d�y sai?', 'M?i c?nh l� c?nh chung c?a �t nh?t ba m?t', 'M?i d?nh l� d?nh chung c?a �t nh?t ba c?nh', ' M?i d?nh l� d?nh chung c?a �t nh?t ba m?t', 'M?i m?t c� �t nh?t ba c?nh', 'M?i c?nh l� c?nh chung c?a �t nh?t ba m?t', NULL, NULL);
INSERT INTO de_thi_toan (maDe, cau, noiDungCauHoi, A, B, C, D, dapAnDung, loiGiai, dapAnChon) VALUES ('toan1', 3, 'M?i d?nh c?a m?t h�nh da di?n l� d?nh chung c?a �t nh?t', 'Nam c?nh', 'B?n c?nh', 'Ba c?nh', 'Hai C?nh', 'Ba c?nh', NULL, NULL);
INSERT INTO de_thi_toan (maDe, cau, noiDungCauHoi, A, B, C, D, dapAnDung, loiGiai, dapAnChon) VALUES ('toan1', 2, 'Cho t? di?n ABCD c� th? t�ch b?ng 12 v� G l� tr?ng t�m c?a tam gi�c BCD T�nh th? t�ch V c?a kh?i ch�p A.GBC', 'V = 6', 'V = 4', 'V = 5', 'V = 3', 'V = 4', NULL, NULL);
INSERT INTO de_thi_toan (maDe, cau, noiDungCauHoi, A, B, C, D, dapAnDung, loiGiai, dapAnChon) VALUES ('toan1', 1, 'Trong kh�ng gian v?i h? tr?c t?a d? Oxyz, cho m?t ph?ng (P) 2x+y-1=0. M?t ph?ng (P) c� 1 vecto ph�p tuy?n l� ', ' (-2;-2;1)', '(2;1;-1)', '(1;2;0)', '(2;1;0)', '(2;1;0)', NULL, NULL);

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

INSERT INTO ma_de (maDe, soCau, thoiGian, tinhTrang, maMonHoc, diem) VALUES ('hoa1', 5, 20, 'Chua L�m', 'hoa', NULL);
INSERT INTO ma_de (maDe, soCau, thoiGian, tinhTrang, maMonHoc, diem) VALUES ('li1', 5, 20, 'Chua L�m', 'li', NULL);
INSERT INTO ma_de (maDe, soCau, thoiGian, tinhTrang, maMonHoc, diem) VALUES ('toan1', 5, 20, 'Chua L�m', 'toan', NULL);
INSERT INTO ma_de (maDe, soCau, thoiGian, tinhTrang, maMonHoc, diem) VALUES ('su1', 5, 20, 'Chua L�m', 'su', NULL);
INSERT INTO ma_de (maDe, soCau, thoiGian, tinhTrang, maMonHoc, diem) VALUES ('anh1', 5, 20, 'Chua L�m', 'anh', NULL);
INSERT INTO ma_de (maDe, soCau, thoiGian, tinhTrang, maMonHoc, diem) VALUES ('sinh1', 5, 20, 'Chua L�m', 'sinh', NULL);
INSERT INTO ma_de (maDe, soCau, thoiGian, tinhTrang, maMonHoc, diem) VALUES ('gdcd1', 5, 20, 'Chua L�m', 'gdcd', NULL);
INSERT INTO ma_de (maDe, soCau, thoiGian, tinhTrang, maMonHoc, diem) VALUES ('dia1', 5, 20, 'Chua L�m', 'dia', NULL);

-- Table: mon_hoc
DROP TABLE IF EXISTS mon_hoc;

CREATE TABLE mon_hoc (
    maMon  STRING  PRIMARY KEY,
    tenMon STRING,
    tongDe INTEGER
);

INSERT INTO mon_hoc (maMon, tenMon, tongDe) VALUES ('gdcd', 'Gi�o D?c C�ng D�n', 1);
INSERT INTO mon_hoc (maMon, tenMon, tongDe) VALUES ('dia', '�?a L�', 1);
INSERT INTO mon_hoc (maMon, tenMon, tongDe) VALUES ('su', 'L?ch S?', 1);
INSERT INTO mon_hoc (maMon, tenMon, tongDe) VALUES ('sinh', 'Sinh H?c', 1);
INSERT INTO mon_hoc (maMon, tenMon, tongDe) VALUES ('hoa', 'H�a H?c', 1);
INSERT INTO mon_hoc (maMon, tenMon, tongDe) VALUES ('li', 'V?t L�', 1);
INSERT INTO mon_hoc (maMon, tenMon, tongDe) VALUES ('anh', 'Ti?ng Anh', 1);
INSERT INTO mon_hoc (maMon, tenMon, tongDe) VALUES ('toan', 'To�n', 1);

COMMIT TRANSACTION;
PRAGMA foreign_keys = on;
