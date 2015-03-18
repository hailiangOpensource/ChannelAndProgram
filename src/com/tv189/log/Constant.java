package com.tv189.log;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

//import com.tv189.api.logger.MyLoggerManager;


public class Constant {
	public static final boolean IS_CONSOLE_PRINT = true;  //是否打印debug信息
	public static final String PARA_REQUEST_UUID = "uuid";
	public static final String PARA_REQUEST_DATE = "req_date";
	public static final String PLAY_LIVE_BACK_REPLACE_PLAYSEEK = "playseek=live";
	public static final String PLAY_LIVE_BACK_REPLACE_FODLE = "tycms/";
	public static final String PLAY_LIVE_BACK_REPLACE_START_FROM = "live01";
	public static final String PLAY_LIVE_BACK_REPLACE_START_TO = "tvod01";
	public static final String FREE_PRODUCT_TICKECT = "1000000129";
	public static final Integer BMS_NO_RESPONSE=10008;
	public static final String KEY = "key";//日志字段
	public static final String TIME = "time";//日志字段
	public static final String OTT_TOKEN = "ottToken";//日志字段
	public static final String UA = "UA";  //日志字段
	public static final String MOBILE = "mobile";   //记录日记中的终端类型
	public static final String USER_ANGENT = "user-agent";  //用户user_angent
	public static final String CHECK_IMS_METHOD = "getMpnumberByIMSI";
	public static final String CHECK_IMS_REQ = "CheckIMSIReq";
	public static final String CHECK_IMS_REQ_PARA = "Imsi";
	public static final String MP_NUMBER = "30000000000";  //反查imssi中查不到返回的字段
	public static final String DEFAULT_MP_NUMBER = "40000000000";  //反查imssi中查不到返回的字段
	public static final String OK = "OK"; 
	public static final String EMPTY = "";
	public static final String STRING_ZERO = "0";   //字符串0常量
	public static final Integer INT_ONE = 1; //int类型1常量
	public static final Integer INT_ZERO = 0;//int类型0常量
	public static final Integer INT_TWO = 2;//int类型2常量
	public static final Integer INT_THREE = 3;//int类型3常量
	public static final String STRING_ONE = "1";//字符串1常量
	public static final String STRING_TWO = "2";//字符串2常量
	public static final String STRING_THREE = "3";//字符串3常量
	public static final String STRING_NINE = "9";//字符串9常量
	public static final String STRING_TEN = "10";//字符串10常量
	public static final String STRING_ELEVEN = "11";//字符串11常量
	public static final String STRING_TWELVE = "12";//字符串12常量
	public static final String STRING_THIRTEEN = "13";//字符串13常量
	public static final Integer ACCOUNT_TYPE_BROAD = 1;  //账号类型宽带
	public static final Integer ACCOUNT_TYPE_OTHER = 6;  //账号类型其它
	public static final Integer RESET_PASS_OP_TYPE = 2;  //重置密码操作参数
	public static final String JSON = "json"; //节目搜索中的返回格式
	public static final String PLAY_COUNT_DESC = "playcount desc"; //keywordSearch搜索中按播放次数排序
	public static final String COVER = "cover"; //节目封面字段
	public static final String MBCONTENTID = "mbcontentid"; //手机节目的内容id
	public static final String PLATS = "plats"; //节目所属平台
	
	public static final Integer PASSWORD_LENGTH = 6;  //密码长度
	public static final Integer MESSAGE_LENGTH = 4;  //验证码长度
	public static final Integer UUID_LENGTH = 6;    //用户随机id位数
	public static final String CLIENT_PC = "PC"; //PC客户端
	
	public static final String OTT_LOGIN_SIGN = "fdc6b8051367114420ea4655479a6403";   //ott登陆接口签名秘钥
	public static final String BMS_PAY_CREATE_ORDER_KEY="faf5cdb075a7e1061fab7765e0cc73e0";//bmspay/payment/bmsTradeBankOrderPayApply.actio
	public static final String STR_NO_BIND_ACCOUNT = "31803";
	public static final Integer INT_NO_BIND_ACCOUNT = 31803;
	
	public static final Integer COMMENT_BLACK_LIMIT_CODE=12001;    //黑名单返回代码
	
	public static final Integer PAGE_NO_DEFAULT_0 = 0;  //默认的页数0
	public static final Integer PAGE_NO_DEFAULT_1 = 1; //默认的页数1
	
	public static final Integer PAGE_SIZE_DEFAULT_10 = 10;//默认每页面显示记录条数
	
	public static final Integer PAGE_SIZE_DEFAULT_MAX = 200; //默认每页最大条数
	
	public static final Integer INDEX_ID_DEFAULT_1 = 1;	//默认的indexid值,UserActionService中用到
	
	public static final Integer ERROR_DEFAULT_INT_FLAG = -1; //错误
	
	public static final String IntegralPresent = "IntegralPresent";
	public static final String IntegralQry = "IntegralQry";
	public static final Integer USER_EXP_TYPE=3;
	
	public static final String SEARCH_ATTRS = "tag,title,categoryId,subcategoryId,director,cast,host,guests";  //搜索前取的视频的字段
	
	public static final String TV_CDNTYPE ="2";  //TV的cdn类型
	
	public static final String MOBIHTTP ="mobihttp";  //http协议流
	
	public static final String HTTP_TYPE = "1";
	public static final String RTSP_TYPE = "2";
	
	public static final String RTMP ="rtmp";  //直播协议
	
	public static final String RTSP ="rtsp";  //直播协议
	
	public static final String IPAD_PLAY_INFO_SUFFIX =".m3u8";  //ipad取的点播播放url加的后缀
	
	public static final Integer DOWN_LOAD = 1;
	public static final Integer PLAY_ONLINE = 2;
	
	public static final String MER_CODE ="010200001370";  //商户编号
	public static final String ALI_KEY = "faf5cdb075a7e1061fab7765e0cc73e0"; //第三方支付的秘钥
	public static final Integer MONTH_DAYS = 30; //包月的天数
	public static final Integer ONE_DAYS = 3; //包月的天数
	public static final Long MESSAGE_TIME_OUT = 60000L; //短信重复发送时间,毫秒数
	public static final String USER_BIND_KEY = "fdc6b8051367114420ea4655479a6403";  //BMS绑定签名秘钥
	
	
	public static final String MESSAGE_USER = "PANWANG";   //短信用户名
	public static final String MESSAGE_PASS = "F177DB6435A928F51F3FAF1DCBB91D49";
	public static final String MESSAGE_TYPE = "1";   //短信类型

	public static final String TICKET_ENCRYPT = "&msisdn=%s&timestamp=%s&clientip=%sMDN2000";   //话单加密数据

    	public static final String TICKET_INFO_OLD = "&msisdn=%s&timestamp=%s&H=%s&channelid=%s&nodeid=%s&videotype=%s&encrypt=%s&ua=%s&imsi=%s";  //话单数据
	
	public static final String TICKET_INFO_NEW = "&version={0}&app={1}&cookie={2}&session={3}&uid={4}&uname={5}&time={6}&videotype={7}&cid={8}&cname={9}&ip={10}"
	            +"&dev={11}&ep={12}&etv={13}&osx={14}&ps={15}&clienttype={16}&deviceid={17}&appver={18}&res={19}&channelid={20}"
	            +"&pid={21}&orderid={22}&nid={23}&netype={24}&isp={25}&cp={26}&sp={27}";  //话单数据
	  public static final String  TICKET_INFO_DOMAIN[]              = {
	    	    "dl2.v.vnet.mobi", "iphonelive.v.vnet.mobi",
	    	    "hlive.tv189.cn", "rlive.tv189.cn", "tlive.tv189.cn","rtspvod.tv189.cn"};

	public static final String stbId="stbId";
	public static final String terminalNo="terminalNo";
	public static final String clientCode="clientCode";
	public static final String optId="optId";
	public static final String time="time";
	
	public static final Integer DEFAULT_LIMIT = 100;
	public static final String QR_CODE_TYPE= "png";
	
	public static final Integer TERMINAL_LOGIN = 1;
	public static final Integer CHINA_TV_LOGIN = 2;
	public static final Integer INTERNATIONAL_TV_LOGIN = 3;
	
	public static final String CURRENCY = "RMB"; //支付账户的币种
	
	public static final String USERACTION_TYPE_addfavourite="addfavourite";
	public static final String CLASS = "class"; //类反射为map的时候多出的参数key
	
	public static final String SEARCH_STATUS_NORMAL = "AND (status:10)";  //节目看搜索条件中状态条件
	public static final String PC_STATUS_NORMAL = "AND (status:8)";  		//节目看搜索条件中状态条件
	
	public static final Integer FILE_LIMIT_DEFAULT = 2;  //互联网电视二维码默认返回数
	
	public static final String FORMAT_JSON = "json";
	public static final String FORMAT_XML = "xml";
	public static final String PAYMETHOD="paymethod"; //支付宝支付类型
	
	public static final String FREE_PRODUCT_ID = "1000000002";  //免费的产品id
	public static final Integer PHONE_LENGTH = 11;  //免费的产品id
	
	public static final String DEFAULT_SERVER_IP = "180.153.149.11";//服务器外网ip
	public static final String PC_FIND_OTHER_ATTRS = "title,director,cast,host,guests,tag,categoryids";
	public static final String DEFAULT_CLIENT_H = "0099";//话单参数
	public static final String DEFAULT_TV_H = "50";//话单参数
	public static final String DEFAULT_UA = "00";//话单参数
	public static final String DEFAULT_UNAME="10000000000";
	public static final String DEFAULT_MOBILE_MM_APPID="10170065000";
	public static final String DEFAULT_MOBILE_MM_UNAME="50000000000";

	public static final String PHONE_FIND_OTHER_ATTRS = "title,director,cast,host,guests,tag,subcategoryId,categoryId";
	public static final String title = "title";
	public static final String director = "director";
	public static final String cast = "cast";
	public static final String host = "host";
	public static final String guests = "guests";
	public static final String tag = "tag";
	public static final String subcategoryId = "subcategoryId";
	public static final String subCategoryId = "subCategoryId";
	public static final String categoryId = "categoryId";
	public static final String yes = "yes";
	
	
	public static final String PC_AUTH_OTHER_ATTRS = "vipstylecode,price,mbcontentid";
	public static final String price = "price";
	public static final String vipstylecode = "vipstylecode";
	
	public static final String AUTH_ATTRS = "productId,ppvStyle,ppvId,mbcontentid"; //鉴权所需要的字段
	public static final String plat = "plat"; //平台
	public static final String FREE_UID = "free";
	public static final String productId = "productId";
	
	public static final String level = "level";
	public static final String params = "params";
	public static final String condition = "condition";
	public static final String size = "size";
	public static final String attrs = "attrs";
	public static final String order = "order";
	public static final String defaultOrder = "publishTime desc";
	public static final String page = "page";
	public static final String facet = "facet";
	public static final String facet_fields = "facet_fields";
	public static final String times = "times";
	//PC的免费产品包
	public static final String FREE_PC_PRODUCT_ID = "0000";
	
//	1点播节目，
//	2直播节目，
//	3直播频道

	/**节目类型1:点播节;2.直播节目,3:直播频道*/
	public static final String  COTENT_TYPE_PRO = "1";
	public static final String  COTENT_TYPE_LIVE_PRO = "2";
	public static final String  COTENT_TYPE_LIVE_CHANEL = "3";
	
	// 网络类型
	public static final String  NET_TYPE_CTWAP = "1";
	public static final String  NET_TYPE_CTNET = "2";
	
	// 终端类型
	/**
	 *  客户端4 
	 */
	public static final String  TERMI_TYPE_CLIENT4 = "10";
	/**
	 *  客户端5
	 */
	public static final String  TERMI_TYPE_CLIENT5 = "20";
	/**
	 *  子客户端 
	 */
	public static final String  TERMI_TYPE_SUBCLIENT= "11";
	
	/**
	 * 按天交付类型
	 */
	public static final String LOG_NAME_TYPE_DAY = "1";
	
	/**
	 * 按小时交付类型<br/>
	 * 每小时交付一次上一个小时的数据（例：9：00交付，8：00-8:59:59秒的数据）<br/>
	 */
	public static final String LOG_NAME_TYPE_HOURE = "2";
	
	public static final String PID = "pid";
	
	public static final String cid = "cid";
	
	public static final String coverNormal = "coverNormal";
	
	public static final String STRING_NULL = "null";
	
	/**
	 * 从IMSI获取运营商类型
	 */
	public static final Integer MNC_BEGIN = 0;
	public static final Integer MNC_END = 5;
	public static final Integer IMSI_length = 15;
	
	/**电信**/
	public static final int Chinatelecom = 1;
	/**移动**/
	public static final int ChinaMobile = 2;
	/**联通**/
	public static final int ChinaUnicom = 3;
	
	/**天迈   **/
	public static final String tm="TVM";
	
	public static List<String> NETTYPES=new ArrayList<String>(); //网络类型
	
	static{
		NETTYPES.add("CTWAP");
		NETTYPES.add("CTNET");
		NETTYPES.add("WIFI");
		NETTYPES.add("CMWAP");
		NETTYPES.add("CMNET");
	}
	public static final String MSGSVCID="11011";
	public static final String MSGPASS="111111";
	public static final int MSGNETTYPE=2;
	public static final int MSGTYPE=1;
	public static final int MSGSMSTYPE=5;
	
	
	public static final String ECID ="ecid";
	public static final String IPSIGN_KEY = "9A22CDEAB6F444D396EA2A22511A1E88";
	public static Map<String,String> playQuality=null;
//	public static Map<String,String> liveQuality=new HashMap<String, String>();
	/**
	 * 点播匹清晰度 
	 */
	 static {
		playQuality=new HashMap<String, String>();
		playQuality.put("4096", "P1024-5");
		playQuality.put("512", "450P");
		playQuality.put("4", "M150-2");
		playQuality.put("32", "450P");
		playQuality.put("16", "P300-5");
		playQuality.put("128", "1080P");
		playQuality.put("1", "M050-2");
		playQuality.put("8", "P150-5");
		playQuality.put("2", "P050-5");
		playQuality.put("64", "720P");
		playQuality.put("256", "450P");	
	}	
	public static String[]appids={
		"10300001000",
		"10400001000",
		"40300001000",
		"40400001000",
		"30300001000",
		"30400001000",
		"30400011000",
		"70300001000",
		"70400001000",
		"10100002000",
		"10200003000",
		"10500001000",
		"10160001000",
		"10260002000",
		"80260002000",
		"10260003000",
		"10160005000",
		"10160006000",
		"60160007000",
		"20460008000",
		"10460009000",
		"90260010100",
		"80360003000",
		"10260010400",
		"40160010100",
		"90160010100",
		"80260010300",
		"10260010402",
		"10260006000",
		"90360010100",
		"10260016000",
		"10260026000",
		"40160011100",
		"90360011100",
		"10260036000",
		"20550018001",
		"10200000013",
		"10200000014",
		"70440001000",
		"80260002300",
		"80260002301",
		"10260000015",
		"40160011101",
		"90360012101",
		"10260000016",
		"40160011201",
		"10260000017",
		"10570001000",
		"90570002000",
		"10270003000",
		"90170004000",
		"10550019000",
		"40570005000",
		"10550020000",
		"10570006000",
		"10150021000",
		"10150022000",
		"10460009000",
		"90360011101",
		"90170007000",
		"10160010000",
		"10160011000",
		"10160012000",
		"90160013000",
		"10170008000",
		"10170009000",
		"10170010000",
		"10170011000",
		"10170012000",
		"10170013000",
		"10170014000",
		"10170015000",
		"10170016000",
		"10170017000",
		"10170018000",
		"10170019000",
		"10170020000",
		"10170021000",
		"10170022000",
		"10170023000",
		"40100038000",
		"30460015000",
		"50370019000",
		"40570024000",
		"40570025000",
		"30570026000",
		"40570027000",
		"30570028000",
		"10470029000",
		"80470030000",
		"90470031000",
		"10570032000",
		"90170033000",
		"80270034000",
		"90170035000",
		"10170036000",
		"10170037000",
		"10170038000",
		"10170039000",
		"40170012000",
		"10170024000",
		"10170065000",
		"10170066000",
		"10170067000",
		"10570073000",
		"40570074000",
		"40570075000",
		"10170077000",
		"90170078000",
		"80570079000",
		"80570080000",
		"80470081000",
		"10170082000",
		"30570089000",
		"40170090000",
		"90170091000",
		"80170092000",
		"10570093000",
		"10170094000",
		"80270095000",
		"80170096000",
		"10170101000",
		"10170102000",
		"10170103000",
		"90170104000",
		"60570105000",
		"90570106000",
		"90570107000",
		"10270108000",
		"30270109000",
		"70270110000",
		"40270111000",
		"90270112000",
		"10170113000",
		"10170114000",
		"10170115000",
		"10170116000",
		"10170117000",
		"10570118000",
		"10570119000",
		"10570120000",
		"10170121000",
		"10170122000",
		"40170123000",
		"10170124000",
		"40170125000",
		"40170126000",
		"10570128000",
		"10570129000",
		"10170130000",
		"10170131000",
		"40170132000",
		"10570133000",
		"10570134000",
		"107020410001",
		"107020310002",
		"107020410007",
		"107020410008",
		"104020210009",
		"404050210010",
		"107020210011",
		"107020410012",
		"107020410013",
		"107020410014",
		"107020410015",
		"107020410016",
		"107020410017",
		"107020410018",
		"107020410019",
		"104020210020",
		"108020510021",
		"107020410022",
		"107020410023",
		"107020410024",
		"107020410025",
		"107020410026",
		"107020410030",
		"107020410031",
		"107020410032",
		"104020210035",
		"104010210036",
		"104020410037",
		"107020410038",
		"104020210039",
		"104010210040",
		"107020410042",
		"107020410044",
		"107020210046",
		"107020410047",
		"104020410048",
		"106020210049",
		"107020410050",
		"107020410051",
		"107020410052",
		"107020410054",
		"107020410055",
		"107020410056"};

}
