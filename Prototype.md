# Introduction #

แสดงรายละเอียดว่าต้องมีหน้าจออะไรบ้าง มีกี่หน้าจอโดยแบ่งเป็น input, report


# Details #
input
  * 1.Customer Order , table CO**ออเดอร์, CO\_ITEM สินค้าที่อยู่ในออร์เดอร์ แสดงในหน้าเดียวกัน โดยเพิ่ม order ได้ภายในหน้านี้เลย
  * 2.Forecast Demand , table forecast** สามารถ CRUD เป็น table เดียว
  * 3.Purchase requisition, table PR**, PR\_ITEM PR เป็นหัวเอกสาร PR\_ITEM เป็นลูก CRUD ตรงหัวมีปุ่ม approve เพื่อเปลี่ยนสถานะ เพื่อกลายเป็น PO
  * 4.Production Management ,table JOB (search และ CRUD ภายในหน้าเดียว)
  * 5.Purchase Order , table PO, PO\_ITEM (search และ CRUD ภายในหน้าเดียว)**

Add your content here.  Format your content with:
  * Text in **bold** or _italic_
  * Headings, paragraphs, and lists
  * Automatic links to other wiki pages