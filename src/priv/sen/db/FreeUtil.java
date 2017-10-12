package priv.sen.db;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;
import freemarker.cache.StringTemplateLoader;
import freemarker.core.ParseException;
import freemarker.template.Configuration;
import freemarker.template.MalformedTemplateNameException;
import freemarker.template.Template;
import freemarker.template.TemplateException;
import freemarker.template.TemplateNotFoundException;

/**
 * @author 
 * MiansenWang 2
 * 017��9��14�� 
 * ����3:21:37 
 * freemarkerģ�����ʵ����
 */
public class FreeUtil {
	public static void main(String[] args) throws IOException, Exception {
		HashMap<String, Object> map = new HashMap<>();
		
		HashMap<String, String> dateMap = new HashMap<>();
		dateMap.put("int", "age");
		dateMap.put("String", "name");
		
		
		createEntryClassBody(dateMap,"Menp","priv/sen/entry".replace("/", "."));
		
		
	}

	/**
	 * ����ʵ�����õ���freemarker
	 * @param file2:ģ��·��
	 * @param dateMap:key��������values��ֵ����
	 * @param className:����
	 * @param packageName:����
	 * @throws URISyntaxException
	 * @throws IOException
	 * @throws TemplateNotFoundException
	 * @throws MalformedTemplateNameException
	 * @throws ParseException
	 * @throws TemplateException
	 */
	public static void createEntryClassBody(HashMap<String, String> dateMap, String className, String packageName)
			throws URISyntaxException, IOException, TemplateNotFoundException, MalformedTemplateNameException,
			ParseException, TemplateException {
		
		HashMap<String, Object> map = new HashMap<>();
		map.put("classname", className);
		map.put("packagename", packageName);
		map.put("colunms", dateMap);
		
		URL rr = FreeUtil.class.getClassLoader().getResource(".");//��ǰ��ַ
		//ʵ����д���ĵ�ַ
		String replace = rr.getFile().replace("bin", "src");//����src��ַ
		replace+=packageName.replace(".", "/");
		replace+="/"+className+".java";
		System.out.println(replace);
		File file = new File(replace);// д��������
		URL resource = EntryGenerator.class.getResource(".");	
		File file2 = new File(resource.toURI());
		String templateName = "entry.tpl";// ģ������
//		String string = getString(map, file, file2, templateName);
//		System.out.println(string);
		toFile(map,file,file2,templateName);	
	}

	/**
	 * ��freemarker�����������ļ���
	 * @param templateName
	 * @param map:������Ϣ
	 * @param file:����ļ���File
	 * @param path:ģ��·��
	 * @param templateName:ģ������
	 * @throws IOException
	 * @throws URISyntaxException
	 * @throws TemplateNotFoundException
	 * @throws MalformedTemplateNameException
	 * @throws ParseException
	 * @throws TemplateException
	 */
	@SuppressWarnings("unused")
	private static void toFile(Map<String, Object> map, File file,File path, String templateName)
			throws IOException, URISyntaxException, TemplateNotFoundException, MalformedTemplateNameException,
			ParseException, TemplateException {

		Configuration con = new Configuration(Configuration.VERSION_2_3_23);
		con.setDefaultEncoding("UTF-8");
//		URL resource = JDBC_OOP.class.getResource(".");// ·��
//		File file2 = new File(resource.toURI());
		con.setDirectoryForTemplateLoading(path);
		Template template = con.getTemplate(templateName);// ģ���ַ
		FileOutputStream fileOutputStream = new FileOutputStream(file);
		OutputStreamWriter outputStreamWriter = new OutputStreamWriter(fileOutputStream);
//		FileWriter fileWriter = new FileWriter(file);
		template.process(map, outputStreamWriter);
	}

	/**
	 * ��freemarker�����������ڴ�������
	 * ��ȡ���պϳɵ��ַ���
	 * @param map
	 * @param file
	 * @param path
	 * @param templateName
	 * @return new String(byteArray,"UTF-8");
	 * @throws IOException
	 * @throws URISyntaxException
	 * @throws TemplateNotFoundException
	 * @throws MalformedTemplateNameException
	 * @throws ParseException
	 * @throws TemplateException
	 */
	@SuppressWarnings("unused")
	private static String getString(Map<String, Object> map,String template)
			throws IOException, URISyntaxException, TemplateNotFoundException, MalformedTemplateNameException,
			ParseException, TemplateException {

		Configuration con = new Configuration(Configuration.VERSION_2_3_23);
		con.setDefaultEncoding("UTF-8");
		StringTemplateLoader templateLoader = new StringTemplateLoader();
		templateLoader.putTemplate("aaa", template);
		con.setTemplateLoader(templateLoader);
		URL resource = EntryGenerator.class.getResource(".");// ·��
		File file2 = new File(resource.toURI());
//		con.setDirectoryForTemplateLoading(path);
		Template tt = con.getTemplate("aaa");// ģ���ַ
		ByteArrayOutputStream stream = new ByteArrayOutputStream();//д���ڴ���
		OutputStreamWriter writer = new OutputStreamWriter(stream);
		tt.process(map, writer);
		byte[] byteArray = stream.toByteArray();
		return new String(byteArray,"UTF-8");
	}
}
