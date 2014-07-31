package com.liu.baobiao.action;

import java.io.FileOutputStream;
import java.util.List;

import javax.annotation.Resource;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFCellStyle;
import org.apache.poi.hssf.usermodel.HSSFFont;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import com.liu.baobiao.dao.DakehuDao;
import com.liu.baobiao.model.Dakehu;
import com.liu.baobiao.vo.searchInfo;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

@SuppressWarnings({ "serial", "rawtypes" })
@Component("writeexcel")
@Scope("prototype")
public class writeExcel extends ActionSupport implements ModelDriven {

	private searchInfo searchInfo = new searchInfo();

	@Resource
	private DakehuDao dakehuDao;

	private List<Dakehu> cadakehus;
	private List<Dakehu> zhdakehus;

	public int beginI = 0;

	public HSSFWorkbook writeworkbook = new HSSFWorkbook();
	public HSSFSheet writesheet = writeworkbook.createSheet();
	public HSSFFont font = writeworkbook.createFont();
	public HSSFCellStyle cellStyle = writeworkbook.createCellStyle();

	@Override
	public String execute() throws Exception {
		FileOutputStream fileOutputStream = new FileOutputStream(
				"D:\\Apache2.2\\htdocs\\Test\\upload\\"
						+ searchInfo.getChupiaoriqi() + ".xls");
		writesheet.setColumnWidth((short) 0, (short) 2755);
		writesheet.setColumnWidth((short) 2, (short) 2355);
		writesheet.setColumnWidth((short) 3, (short) 5255);
		writesheet.setColumnWidth((short) 6, (short) 1255);
		writesheet.setColumnWidth((short) 10, (short) 1755);
		writesheet.setColumnWidth((short) 12, (short) 3355);

		font.setFontName("宋体");
		font.setFontHeightInPoints((short) 12);
		font.setBoldweight(HSSFFont.BOLDWEIGHT_BOLD);// 字体加粗

		cellStyle.setAlignment(HSSFCellStyle.ALIGN_CENTER);// 居中
		cellStyle.setFont(font);
		cellStyle.setBorderBottom(HSSFCellStyle.BORDER_THIN); // 下边框
		cellStyle.setBorderLeft(HSSFCellStyle.BORDER_THIN);// 左边框
		cellStyle.setBorderTop(HSSFCellStyle.BORDER_THIN);// 上边框
		cellStyle.setBorderRight(HSSFCellStyle.BORDER_THIN);// 右边框

		exceltaitou();

		cadakehus = dakehuDao.findBychupiaoriqiandhangkonggongsi(
				searchInfo.getChupiaoriqi(), "CA");
		zhdakehus = dakehuDao.findBychupiaoriqiandhangkonggongsi(
				searchInfo.getChupiaoriqi(), "ZH");

		writehkgs(beginI, cadakehus);
		writehkgs(beginI, zhdakehus);
		writeworkbook.write(fileOutputStream);
		fileOutputStream.flush();
		fileOutputStream.close();
		return "success";
	}

	private void exceltaitou() {
		String riqi = searchInfo.getChupiaoriqi().substring(4, 6) + "月";
		basicstring(0, 0, riqi);
		basicstring(1, 0, "订单号");
		basicstring(1, 1, "采购商");
		basicstring(1, 2, "旅客姓名");
		basicstring(1, 3, "PNR");
		basicstring(1, 4, "票号");
		basicstring(1, 5, "航程");
		basicstring(1, 6, "航班");
		basicstring(1, 7, "舱位");
		basicstring(1, 8, "乘机日期");
		basicstring(1, 9, "票面价");
		basicstring(1, 10, "税");
		basicstring(1, 11, "代理费");
		basicstring(1, 12, "支出金额");
		basicstring(1, 13, "实收金额");
		basicstring(1, 14, "利润");
		basicstring(1, 15, "备注");
		basicstring(1, 16, "人数");
	}

	// 航空公司写入excel通用
	public void writehkgs(int begin, List<Dakehu> hkgs) {
		if (hkgs.size() > 0) {
			beginI += hkgs.size() + 2;
		}
		for (int i = begin; i < hkgs.size() + begin; i++) {
			basicstring(i + 2, 0, hkgs.get(i - begin).getOrdid());
			basicstring(i + 2, 1, hkgs.get(i - begin).getCaigoushang());
			basicstring(i + 2, 2, hkgs.get(i - begin).getXingming());
			basicstring(i + 2, 3, hkgs.get(i - begin).getPnr());
			basicstring(i + 2, 4, hkgs.get(i - begin).getPiaohao());
			basicstring(i + 2, 5, hkgs.get(i - begin).getHangcheng());
			basicstring(i + 2, 6, hkgs.get(i - begin).getHangban());
			basicstring(i + 2, 7, hkgs.get(i - begin).getCangwei());
			basicstring(i + 2, 8, hkgs.get(i - begin).getChengjiriqi());
			basicnumber(i + 2, 9,
					Integer.valueOf(hkgs.get(i - begin).getPiaomianjia()));
			basicnumber(i + 2, 10,
					Integer.valueOf(hkgs.get(i - begin).getShuifei()));
			basicstring(i + 2, 11, "3%");
			basicdouble(i + 2, 12,
					Double.valueOf(hkgs.get(i - begin).getZhichujine()));
			basicdouble(i + 2, 13,
					Double.valueOf(hkgs.get(i - begin).getShishou()));
			basicdouble(i + 2, 14,
					Double.valueOf(hkgs.get(i - begin).getLirun()));
			basicstring(i + 2, 15, hkgs.get(i - begin).getBeizhu());
			basicnumber(i + 2, 16,
					Integer.valueOf(hkgs.get(i - begin).getRenshu()));
		}
	}

	// 给单元格赋值,字符串的
	public void basicstring(int rownum, int cellnum, String value) {
		HSSFRow hssfRow = writesheet.createRow((short) rownum);
		hssfRow.setHeight((short) 480);
		HSSFCell hssfCell = hssfRow.createCell((short) cellnum);
		hssfCell.setCellStyle(cellStyle);
		hssfCell.setEncoding(HSSFCell.ENCODING_UTF_16);
		hssfCell.setCellValue(value);
	}

	// 给单元格赋值,数字的
	public void basicnumber(int rownum, int cellnum, int value) {
		HSSFRow hssfRow = writesheet.createRow((short) rownum);
		hssfRow.setHeight((short) 480);
		HSSFCell hssfCell = hssfRow.createCell((short) cellnum);
		hssfCell.setCellStyle(cellStyle);
		hssfCell.setCellType(HSSFCell.CELL_TYPE_NUMERIC);
		hssfCell.setEncoding(HSSFCell.ENCODING_UTF_16);
		hssfCell.setCellValue(value);
	}

	// 给单元格赋值,double的
	public void basicdouble(int rownum, int cellnum, Double value) {
		HSSFRow hssfRow = writesheet.createRow((short) rownum);
		hssfRow.setHeight((short) 480);
		HSSFCell hssfCell = hssfRow.createCell((short) cellnum);
		hssfCell.setCellStyle(cellStyle);
		hssfCell.setCellType(HSSFCell.CELL_TYPE_NUMERIC);
		hssfCell.setEncoding(HSSFCell.ENCODING_UTF_16);
		hssfCell.setCellValue(value);
	}

	@Override
	public Object getModel() {
		// TODO Auto-generated method stub
		return searchInfo;
	}

}
