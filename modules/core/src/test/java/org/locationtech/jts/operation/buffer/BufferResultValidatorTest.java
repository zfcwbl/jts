
/*
 * The JTS Topology Suite is a collection of Java classes that
 * implement the fundamental operations required to validate a given
 * geo-spatial data set to a known topological specification.
 * 
 * Copyright (C) 2016 Vivid Solutions
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * (http://www.eclipse.org/legal/epl-v10.html), and the Vivid Solutions BSD
 * License v1.0 (found at the root of the repository).
 * 
 */
package org.locationtech.jts.operation.buffer;

import org.locationtech.jts.geom.Geometry;
import org.locationtech.jts.io.WKTReader;
import org.locationtech.jts.operation.buffer.validate.BufferResultValidator;

import junit.framework.TestCase;



/**
 * @version 1.7
 */
public class BufferResultValidatorTest extends TestCase {

	WKTReader rdr = new WKTReader();
	
  public BufferResultValidatorTest(String name) {
    super(name);
  }

  public static void main(String[] args) {
    junit.textui.TestRunner.run(BufferResultValidatorTest.class);
  }

  public void testRandomLineString_envDistanceFailure() throws Exception 
  {
  	String wkt = "LINESTRING (0 0, 0.0050121406740709 -0.0178116943078762, 0.023360713164988 -0.0154225740096356, 0.0242435510469024 -0.0324899203339147, 0.0085030847458749 -0.0391466037351922, -0.0049763942180625 -0.037881923003369, -0.0178369891369056 -0.0336509811666022, -0.0177592362824081 -0.0478222381025471, -0.0261518089363225 -0.059241313936419, -0.0341770463763633 -0.0645869491810857, -0.0427699646025609 -0.0602117910701216, -0.0465729748988988 -0.0703610553736549, -0.0572399695179476 -0.0684412431395525, -0.064840373708758 -0.0597916835657802, -0.075933665026951 -0.0567062480351575, -0.0906286002341713 -0.059530806708663, -0.0891053530465528 -0.0744170073807583, -0.0746455187887388 -0.0582637398359729, -0.0876322125310863 -0.0409039977647514, -0.1069996284174552 -0.0514712920048503, -0.1204569088827982 -0.0339879825884526, -0.1354060760983749 -0.0341983165162511, -0.1424144995136747 -0.0474045211955802, -0.1561943830808726 -0.0516357586378472, -0.1609639311781655 -0.0652386984806159, -0.172820609900011 -0.0479563759837032, -0.1931585264285574 -0.0530188509197635, -0.1876254420927919 -0.0738312584480705, -0.2060740501060544 -0.0849407225109319, -0.1954015340280759 -0.0931083780890523, -0.1913365994785588 -0.1059181206385984, -0.1879772905502195 -0.1185977617930016, -0.1901791119746468 -0.1315287415971536, -0.2055975201959379 -0.1276390095109663, -0.2180744798435294 -0.1374971434993573, -0.2261858140167908 -0.1504179698941716, -0.2236828711990071 -0.1654671151870497, -0.225571090488597 -0.1471690572150352, -0.2434396962271624 -0.1427990198476331, -0.2503470559042911 -0.1628488501608332, -0.2704331618796968 -0.1560476987846242, -0.2550448722209311 -0.1440053393069962, -0.2635574811871452 -0.1264168951177332, -0.2758386441327004 -0.116818079927041, -0.2828404821964569 -0.1028919002610568, -0.2928940810123721 -0.0879293917136913, -0.3108998104218049 -0.0870661306780576, -0.3294214224615548 -0.0886284960279035, -0.3373659412990392 -0.1054325347828655, -0.3503843166187969 -0.1008471110331078, -0.3620893100993321 -0.0935329238225187, -0.3752347454586858 -0.0807205639798017, -0.364050120731684 -0.0661650425105326, -0.3780981811728654 -0.0583863178624236, -0.3740658987852153 -0.0428429186828223, -0.3864807698899518 -0.0394112742622611, -0.397014675967126 -0.0319989850926683, -0.3792640781001624 -0.0475790727438729, -0.3635724248095485 -0.0299270226402436, -0.3531693783166142 -0.0125463838807832, -0.3655005683918717 0.0035238286675586, -0.3493015470929176 0.0029497655991704, -0.3378627422211032 0.0144341716593467, -0.3379405126929051 0.0293510688455208, -0.3406883764612563 0.0440128939235851, -0.3324332748392658 0.0227821327097087, -0.3462851476872376 0.0046985063279884, -0.3661593446838672 0.0075718173506031, -0.3859950986841109 0.0044441207963732, -0.4027319978512339 0.0004805553317992, -0.4150094528052938 0.012526207857646, -0.4311725983161582 0.0071653266858711, -0.4447171238919916 0.0174867677998271, -0.465291792103443 0.0104740624365847, -0.4615219171240586 -0.0109334841571465, -0.4526590891130391 -0.025063534859475, -0.4401615889615084 -0.0361098257829378, -0.451476583234073 -0.0503332357093948, -0.43876845696841 -0.0633270039134291, -0.4220363317446629 -0.0713764311308523, -0.4287707591717834 -0.0886797481614276, -0.4163583595694239 -0.0805826015178939, -0.4017174055456447 -0.0782861013700334, -0.3864498922291822 -0.087086838473576, -0.3893076893621629 -0.1044759998099015, -0.3782293922748502 -0.1056035091475074, -0.3670938749838836 -0.1055894264015696, -0.3613890574287955 -0.1164741204510282, -0.3493671904520086 -0.1190228892282226, -0.3511433302216462 -0.1319276046935007, -0.3402777116820132 -0.139112636876606, -0.3469922590359794 -0.1509770179277757, -0.3377737639033578 -0.1610203257188295, -0.3368889950817616 -0.1732679389871961, -0.3269102987026388 -0.1804242274953837, -0.3177137792270426 -0.1867051970797883, -0.3092836077007141 -0.1939824738659162, -0.3116643890978169 -0.2050741572602805, -0.3229956647241386 -0.2045303252439961, -0.3221430239883363 -0.2150674360329148, -0.331767345466129 -0.2194412371365768, -0.3315329076661971 -0.2298055225437402, -0.3362944034438575 -0.2390142972202375, -0.3470221693455817 -0.2369980102710796, -0.3559158724222612 -0.2433267083905513, -0.3644604760007383 -0.2436755181520328, -0.372881872491775 -0.2421882388562105, -0.3814256019023612 -0.2406668899680489, -0.3898804777999258 -0.2426226221167863, -0.3970018876959567 -0.2364253071078368, -0.4060835430038888 -0.2338475699033603, -0.412594493640082 -0.2439820360262829, -0.4236884218893332 -0.2392889946047656, -0.425726993166183 -0.2499686502941685, -0.4362210512383605 -0.2528121628530928, -0.4454415965196014 -0.2541298962589096, -0.4546585745696004 -0.2527874387221312, -0.4687370955646141 -0.2482192707581446, -0.4645693181446278 -0.2340170686988974, -0.4747109779380611 -0.2373166792512392, -0.4853026776378588 -0.2385643132649516, -0.4823430301358789 -0.2261580832778798, -0.4921708793894377 -0.2180286654095807, -0.5014310346680746 -0.2104343904289632, -0.5131767467491777 -0.2127714261525942, -0.524758242265578 -0.2138677953865533, -0.5281216797546923 -0.225004237913249, -0.5402456559428697 -0.2190784275354333, -0.5464620363415711 -0.2310560166911842, -0.542512721959894 -0.2190727838184703, -0.5299158885511648 -0.2183553284263113, -0.5323313826508866 -0.2081056749441625, -0.5374613194449342 -0.1989092758260843, -0.5308959758078244 -0.192158102294992, -0.5252832259614064 -0.18459641463404, -0.5221681982846436 -0.1741043062332059, -0.5299291504240683 -0.1663870944302677, -0.538075291830999 -0.1606196846947658, -0.5460958408390417 -0.1546788574385282, -0.5571976352029643 -0.1590683728220992, -0.5656419053954334 -0.15062965346914, -0.5626710205200925 -0.1391545786037842, -0.5716905851300862 -0.131463612841658, -0.5620517316800521 -0.1229727179031278, -0.5681678748101774 -0.1116768962906813, -0.5771327800896917 -0.1056434422681761, -0.5826417573967029 -0.0963470309636358, -0.5787652458443208 -0.0819577497852585, -0.5931515506438964 -0.07807020700609, -0.6000930810759233 -0.0897522881719957, -0.613090596340292 -0.0857873843827383, -0.6265660218475042 -0.08732871676454, -0.6283374626939596 -0.1007758278088917, -0.6376657588583103 -0.103841922781183, -0.6474053207345623 -0.1025933307070406, -0.6548736564285454 -0.0953067735503082, -0.654680552705842 -0.0848744840514193, -0.6673818543076171 -0.0797269153099037, -0.6732514461208984 -0.0921111156584666, -0.680340410670068 -0.0848045371912123, -0.6839141811082304 -0.0752720835651596, -0.6952357315689285 -0.0780839448648954, -0.7043638998905275 -0.0708202948254428, -0.7089478156886628 -0.0611570039128909, -0.7170491012862124 -0.0541741214871344, -0.7299366109544918 -0.0489860575040238, -0.743822620267513 -0.0494134433970277, -0.7525108381809805 -0.0614072740889566, -0.7497387870295431 -0.0759555673769118, -0.7639646144394061 -0.0777167567822421, -0.7647857704051172 -0.0920276497137342, -0.7665925966102568 -0.1068906296980722, -0.751925224535934 -0.1098974538338984, -0.7553757071995333 -0.1178721548416768, -0.7582065416490503 -0.1260872667152114, -0.7646431127084641 -0.1319348983754947, -0.7703918589555896 -0.1384599393426758, -0.7782472054819142 -0.148123733387558, -0.7905826527045907 -0.1498360786235145, -0.805019711373555 -0.1498484410770697, -0.8091953806227662 -0.1360284337629413, -0.8239770665663367 -0.138740014308915, -0.8358364299184061 -0.1295092825245303, -0.8317679166580235 -0.1163824870318194, -0.8294437111734797 -0.102837612395154, -0.8347428924366753 -0.1129319903177962, -0.82988311192825 -0.1232451043535887, -0.8422385495990062 -0.1216458574069483, -0.8479693210652968 -0.1327080764082801, -0.8494086824352087 -0.143259925911373, -0.8594354099962246 -0.1468485222255715, -0.8710700404835304 -0.1418156960697787, -0.8764637086499377 -0.1532875010455122, -0.871877966331779 -0.1412974383981378, -0.8823312633464051 -0.1338463165751822, -0.8927539427986722 -0.1352439397632697, -0.9024673537790425 -0.1312146414785791, -0.9169666300372805 -0.1335633933170455, -0.9209834585760139 -0.1194350269676821, -0.9100334022350977 -0.1118099759715185, -0.9133093778973502 -0.0988750186842421, -0.904147237248668 -0.0981354871802091, -0.867761668652526 -0.0926437616303994, -0.8913826744373572 -0.0840621883819444, -0.8812480806037308 -0.0842143981575342, -0.8685379344019649 -0.083568724024858, -0.8675160071300994 -0.0708832844894344, -0.8580205523689814 -0.0613140308561704, -0.8675158498660372 -0.0517446211742423, -0.872409166809526 -0.0609547213497025, -0.8814761088393026 -0.0661084635027518, -0.8953889326977116 -0.0653897157193776, -0.8965747408556268 -0.0792705343228981, -0.8971756623331555 -0.0639311912103026, -0.9092402266247249 -0.0544389395173335, -0.9210951910761328 -0.0619763164030262, -0.9344515553812949 -0.0663305976306128, -0.9293822574409418 -0.0516430853363158, -0.9432685864947324 -0.044672384911463, -0.9334103096655941 -0.0379224973468535, -0.9271045458452278 -0.0277743966961627, -0.9402339665028446 -0.031168284369269, -0.9452756930518931 -0.0185793545598317, -0.945522913806585 -0.0067054298128354, -0.9561187700225338 -0.001340820036736, -0.953028314165927 0.0069471451590414, -0.9539875490127478 0.0157403898955819, -0.9454055349138165 0.0164413901291298, -0.9367970827899018 0.0166335342207932, -0.9348612526701263 0.0262474007677379, -0.9444648321049989 0.0282336359686109, -0.9416892723465026 0.0350367191376586, -0.9436581770452196 0.0421154963530633, -0.9392419545310323 0.0479752065653825, -0.9429529439318587 0.0543051183131185, -0.9498274711576367 0.0567906035358281, -0.9502592194732825 0.0640878876033568, -0.9520104655644192 0.0697913324971662, -0.9506223265991526 0.075593850635143, -0.9522815769508243 0.0816306792021164, -0.949060273844204 0.0869990697590549, -0.9422910357785079 0.092524671810989, -0.939968942049302 0.1009486104823701, -0.9324013321982897 0.1049244389670934, -0.9273714883420019 0.11183650101676, -0.9288062097408671 0.1235145389288624, -0.9183235713304518 0.1288576922043494, -0.9306750764088837 0.1320777269837099, -0.9292202577363909 0.1447588864067668, -0.9370186524242582 0.1524827493617562, -0.9433294881114153 0.1614630818491934, -0.9465907937786249 0.1720205011056855, -0.9466837543675501 0.1830697804641427, -0.961723424524043 0.1824460721954856, -0.9729999178465795 0.1924170996634692, -0.9712379977563 0.1757762035680768, -0.9858512041816034 0.1676228003992367)";
  	runTest(wkt, 1.0);
  }
  
  void runTest(String wkt, double dist)
  throws Exception
  {
  	Geometry g = rdr.read(wkt);
  	Geometry buf = g.buffer(dist);
    BufferResultValidator validator = new BufferResultValidator(g, dist, buf);
    
    if (! validator.isValid()) {
      String msg = validator.getErrorMessage();

      //System.out.println(msg);
      //System.out.println(WKTWriter.toPoint(validator.getErrorLocation()));
    }
  	assertTrue(validator.isValid());
  }
}