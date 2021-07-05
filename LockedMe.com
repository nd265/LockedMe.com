<mxfile host="app.diagrams.net" modified="2021-07-05T10:26:35.179Z" agent="5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/91.0.4472.124 Safari/537.36" etag="IxJ29Ct19TnXrIHvaccM" version="14.8.4" type="github">
  <diagram id="oX1GdSZjUqqk08RNEdlo" name="Page-1">
    <mxGraphModel dx="870" dy="594" grid="1" gridSize="10" guides="1" tooltips="1" connect="1" arrows="1" fold="1" page="1" pageScale="1" pageWidth="827" pageHeight="1169" math="0" shadow="0">
      <root>
        <mxCell id="0" />
        <mxCell id="1" parent="0" />
        <mxCell id="cjXHX25kvEjNAGu8TwTu-1" value="Actor" style="shape=umlActor;verticalLabelPosition=bottom;verticalAlign=top;html=1;outlineConnect=0;" vertex="1" parent="1">
          <mxGeometry x="90" y="240" width="50" height="80" as="geometry" />
        </mxCell>
        <mxCell id="cjXHX25kvEjNAGu8TwTu-2" value="" style="endArrow=classic;html=1;" edge="1" parent="1">
          <mxGeometry width="50" height="50" relative="1" as="geometry">
            <mxPoint x="120" y="279.5" as="sourcePoint" />
            <mxPoint x="160" y="280" as="targetPoint" />
          </mxGeometry>
        </mxCell>
        <mxCell id="cjXHX25kvEjNAGu8TwTu-3" value="LockedMe.com" style="rounded=0;whiteSpace=wrap;html=1;" vertex="1" parent="1">
          <mxGeometry x="160" y="240" width="90" height="80" as="geometry" />
        </mxCell>
        <mxCell id="cjXHX25kvEjNAGu8TwTu-6" value="" style="endArrow=classic;html=1;exitX=1;exitY=0.5;exitDx=0;exitDy=0;" edge="1" parent="1" source="cjXHX25kvEjNAGu8TwTu-3">
          <mxGeometry width="50" height="50" relative="1" as="geometry">
            <mxPoint x="330" y="330" as="sourcePoint" />
            <mxPoint x="260" y="280" as="targetPoint" />
          </mxGeometry>
        </mxCell>
        <mxCell id="cjXHX25kvEjNAGu8TwTu-7" value="Choice Menu&lt;br&gt;1. Get All file Info&lt;br&gt;2. File create/delete/search&lt;br&gt;3. Exit" style="rounded=0;whiteSpace=wrap;html=1;" vertex="1" parent="1">
          <mxGeometry x="260" y="205" width="120" height="150" as="geometry" />
        </mxCell>
        <mxCell id="cjXHX25kvEjNAGu8TwTu-8" value="" style="endArrow=classic;html=1;exitX=1.004;exitY=0.09;exitDx=0;exitDy=0;exitPerimeter=0;" edge="1" parent="1" source="cjXHX25kvEjNAGu8TwTu-7">
          <mxGeometry width="50" height="50" relative="1" as="geometry">
            <mxPoint x="600" y="530" as="sourcePoint" />
            <mxPoint x="460" y="219" as="targetPoint" />
          </mxGeometry>
        </mxCell>
        <mxCell id="cjXHX25kvEjNAGu8TwTu-9" value="1" style="text;html=1;align=center;verticalAlign=middle;resizable=0;points=[];autosize=1;strokeColor=none;" vertex="1" parent="1">
          <mxGeometry x="410" y="200" width="20" height="20" as="geometry" />
        </mxCell>
        <mxCell id="cjXHX25kvEjNAGu8TwTu-10" value="Take root&lt;br&gt;directory" style="rounded=0;whiteSpace=wrap;html=1;" vertex="1" parent="1">
          <mxGeometry x="460" y="170" width="70" height="90" as="geometry" />
        </mxCell>
        <mxCell id="cjXHX25kvEjNAGu8TwTu-11" value="" style="endArrow=classic;html=1;exitX=1;exitY=0.5;exitDx=0;exitDy=0;" edge="1" parent="1" source="cjXHX25kvEjNAGu8TwTu-10">
          <mxGeometry width="50" height="50" relative="1" as="geometry">
            <mxPoint x="620" y="550" as="sourcePoint" />
            <mxPoint x="600" y="215" as="targetPoint" />
          </mxGeometry>
        </mxCell>
        <mxCell id="cjXHX25kvEjNAGu8TwTu-12" value="Display files and folders" style="whiteSpace=wrap;html=1;aspect=fixed;" vertex="1" parent="1">
          <mxGeometry x="600" y="175" width="80" height="80" as="geometry" />
        </mxCell>
        <mxCell id="cjXHX25kvEjNAGu8TwTu-14" value="" style="endArrow=none;html=1;exitX=0.5;exitY=0;exitDx=0;exitDy=0;" edge="1" parent="1" source="cjXHX25kvEjNAGu8TwTu-12">
          <mxGeometry width="50" height="50" relative="1" as="geometry">
            <mxPoint x="640" y="450" as="sourcePoint" />
            <mxPoint x="640" y="140" as="targetPoint" />
          </mxGeometry>
        </mxCell>
        <mxCell id="cjXHX25kvEjNAGu8TwTu-15" value="" style="endArrow=none;html=1;" edge="1" parent="1">
          <mxGeometry width="50" height="50" relative="1" as="geometry">
            <mxPoint x="640" y="140" as="sourcePoint" />
            <mxPoint x="320" y="140" as="targetPoint" />
          </mxGeometry>
        </mxCell>
        <mxCell id="cjXHX25kvEjNAGu8TwTu-16" value="" style="endArrow=classic;html=1;entryX=0.5;entryY=0;entryDx=0;entryDy=0;" edge="1" parent="1" target="cjXHX25kvEjNAGu8TwTu-7">
          <mxGeometry width="50" height="50" relative="1" as="geometry">
            <mxPoint x="320" y="140" as="sourcePoint" />
            <mxPoint x="750" y="460" as="targetPoint" />
          </mxGeometry>
        </mxCell>
        <mxCell id="cjXHX25kvEjNAGu8TwTu-17" value="" style="endArrow=classic;html=1;exitX=0.438;exitY=1.017;exitDx=0;exitDy=0;exitPerimeter=0;" edge="1" parent="1" source="cjXHX25kvEjNAGu8TwTu-7">
          <mxGeometry width="50" height="50" relative="1" as="geometry">
            <mxPoint x="380" y="550" as="sourcePoint" />
            <mxPoint x="313" y="410" as="targetPoint" />
          </mxGeometry>
        </mxCell>
        <mxCell id="cjXHX25kvEjNAGu8TwTu-18" value="3" style="text;html=1;strokeColor=none;fillColor=none;align=center;verticalAlign=middle;whiteSpace=wrap;rounded=0;" vertex="1" parent="1">
          <mxGeometry x="310" y="370" width="40" height="20" as="geometry" />
        </mxCell>
        <mxCell id="cjXHX25kvEjNAGu8TwTu-19" value="Shuts down the application" style="rounded=0;whiteSpace=wrap;html=1;" vertex="1" parent="1">
          <mxGeometry x="260" y="410" width="120" height="60" as="geometry" />
        </mxCell>
        <mxCell id="cjXHX25kvEjNAGu8TwTu-20" value="" style="endArrow=classic;html=1;exitX=1;exitY=0.75;exitDx=0;exitDy=0;" edge="1" parent="1" source="cjXHX25kvEjNAGu8TwTu-7">
          <mxGeometry width="50" height="50" relative="1" as="geometry">
            <mxPoint x="530" y="440" as="sourcePoint" />
            <mxPoint x="420" y="318" as="targetPoint" />
          </mxGeometry>
        </mxCell>
        <mxCell id="cjXHX25kvEjNAGu8TwTu-21" value="2" style="text;html=1;align=center;verticalAlign=middle;resizable=0;points=[];autosize=1;strokeColor=none;" vertex="1" parent="1">
          <mxGeometry x="390" y="300" width="20" height="20" as="geometry" />
        </mxCell>
        <mxCell id="cjXHX25kvEjNAGu8TwTu-22" value="File Manipulation options&lt;br&gt;1. Create a new file&lt;br&gt;2. Delete an existing file&lt;br&gt;3. Search for a file&lt;br&gt;4. Exit context&amp;nbsp;" style="whiteSpace=wrap;html=1;aspect=fixed;" vertex="1" parent="1">
          <mxGeometry x="420" y="270" width="150" height="150" as="geometry" />
        </mxCell>
        <mxCell id="cjXHX25kvEjNAGu8TwTu-27" value="" style="endArrow=classic;html=1;" edge="1" parent="1">
          <mxGeometry width="50" height="50" relative="1" as="geometry">
            <mxPoint x="422" y="345" as="sourcePoint" />
            <mxPoint x="380" y="345" as="targetPoint" />
          </mxGeometry>
        </mxCell>
        <mxCell id="cjXHX25kvEjNAGu8TwTu-34" value="4" style="text;html=1;align=center;verticalAlign=middle;resizable=0;points=[];autosize=1;strokeColor=none;" vertex="1" parent="1">
          <mxGeometry x="390" y="330" width="20" height="20" as="geometry" />
        </mxCell>
        <mxCell id="cjXHX25kvEjNAGu8TwTu-35" value="Take root directory" style="rounded=0;whiteSpace=wrap;html=1;" vertex="1" parent="1">
          <mxGeometry x="620" y="290" width="100" height="150" as="geometry" />
        </mxCell>
        <mxCell id="cjXHX25kvEjNAGu8TwTu-38" value="" style="endArrow=classic;html=1;exitX=1.01;exitY=0.617;exitDx=0;exitDy=0;exitPerimeter=0;" edge="1" parent="1" source="cjXHX25kvEjNAGu8TwTu-22">
          <mxGeometry width="50" height="50" relative="1" as="geometry">
            <mxPoint x="590" y="520" as="sourcePoint" />
            <mxPoint x="620" y="363" as="targetPoint" />
          </mxGeometry>
        </mxCell>
        <mxCell id="cjXHX25kvEjNAGu8TwTu-39" value="1,2,3" style="text;html=1;align=center;verticalAlign=middle;resizable=0;points=[];autosize=1;strokeColor=none;" vertex="1" parent="1">
          <mxGeometry x="570" y="340" width="40" height="20" as="geometry" />
        </mxCell>
        <mxCell id="cjXHX25kvEjNAGu8TwTu-40" value="" style="endArrow=classic;html=1;" edge="1" parent="1">
          <mxGeometry width="50" height="50" relative="1" as="geometry">
            <mxPoint x="722" y="328" as="sourcePoint" />
            <mxPoint x="740" y="328" as="targetPoint" />
          </mxGeometry>
        </mxCell>
        <mxCell id="cjXHX25kvEjNAGu8TwTu-41" value="1. Create file and notify" style="rounded=0;whiteSpace=wrap;html=1;" vertex="1" parent="1">
          <mxGeometry x="740" y="300" width="80" height="40" as="geometry" />
        </mxCell>
        <mxCell id="cjXHX25kvEjNAGu8TwTu-43" value="2. Delete file and notify" style="rounded=0;whiteSpace=wrap;html=1;" vertex="1" parent="1">
          <mxGeometry x="740" y="350" width="80" height="40" as="geometry" />
        </mxCell>
        <mxCell id="cjXHX25kvEjNAGu8TwTu-44" value="" style="endArrow=classic;html=1;exitX=1;exitY=0.5;exitDx=0;exitDy=0;" edge="1" parent="1" source="cjXHX25kvEjNAGu8TwTu-35">
          <mxGeometry width="50" height="50" relative="1" as="geometry">
            <mxPoint x="732" y="338" as="sourcePoint" />
            <mxPoint x="740" y="366" as="targetPoint" />
          </mxGeometry>
        </mxCell>
        <mxCell id="cjXHX25kvEjNAGu8TwTu-45" value="" style="endArrow=classic;html=1;exitX=1;exitY=0.75;exitDx=0;exitDy=0;" edge="1" parent="1" source="cjXHX25kvEjNAGu8TwTu-35">
          <mxGeometry width="50" height="50" relative="1" as="geometry">
            <mxPoint x="770" y="580" as="sourcePoint" />
            <mxPoint x="740" y="403" as="targetPoint" />
          </mxGeometry>
        </mxCell>
        <mxCell id="cjXHX25kvEjNAGu8TwTu-46" value="3. Find matching files and display" style="rounded=0;whiteSpace=wrap;html=1;" vertex="1" parent="1">
          <mxGeometry x="740" y="400" width="80" height="50" as="geometry" />
        </mxCell>
        <mxCell id="cjXHX25kvEjNAGu8TwTu-48" value="" style="endArrow=none;html=1;exitX=0.5;exitY=0;exitDx=0;exitDy=0;" edge="1" parent="1" source="cjXHX25kvEjNAGu8TwTu-41">
          <mxGeometry width="50" height="50" relative="1" as="geometry">
            <mxPoint x="760" y="580" as="sourcePoint" />
            <mxPoint x="780" y="140" as="targetPoint" />
          </mxGeometry>
        </mxCell>
        <mxCell id="cjXHX25kvEjNAGu8TwTu-49" value="" style="endArrow=none;html=1;" edge="1" parent="1">
          <mxGeometry width="50" height="50" relative="1" as="geometry">
            <mxPoint x="780" y="140" as="sourcePoint" />
            <mxPoint x="640" y="140" as="targetPoint" />
          </mxGeometry>
        </mxCell>
        <mxCell id="cjXHX25kvEjNAGu8TwTu-50" value="" style="endArrow=classic;html=1;" edge="1" parent="1">
          <mxGeometry width="50" height="50" relative="1" as="geometry">
            <mxPoint x="640" y="170" as="sourcePoint" />
            <mxPoint x="640" y="150" as="targetPoint" />
          </mxGeometry>
        </mxCell>
        <mxCell id="cjXHX25kvEjNAGu8TwTu-51" value="" style="endArrow=classic;html=1;" edge="1" parent="1">
          <mxGeometry width="50" height="50" relative="1" as="geometry">
            <mxPoint x="780" y="300" as="sourcePoint" />
            <mxPoint x="780" y="200" as="targetPoint" />
          </mxGeometry>
        </mxCell>
        <mxCell id="cjXHX25kvEjNAGu8TwTu-52" value="" style="endArrow=classic;html=1;" edge="1" parent="1">
          <mxGeometry width="50" height="50" relative="1" as="geometry">
            <mxPoint x="610" y="140" as="sourcePoint" />
            <mxPoint x="550" y="140" as="targetPoint" />
          </mxGeometry>
        </mxCell>
        <mxCell id="cjXHX25kvEjNAGu8TwTu-53" value="" style="endArrow=classic;html=1;exitX=1;exitY=0.5;exitDx=0;exitDy=0;" edge="1" parent="1" source="cjXHX25kvEjNAGu8TwTu-43">
          <mxGeometry width="50" height="50" relative="1" as="geometry">
            <mxPoint x="830" y="400" as="sourcePoint" />
            <mxPoint x="860" y="370" as="targetPoint" />
          </mxGeometry>
        </mxCell>
        <mxCell id="cjXHX25kvEjNAGu8TwTu-54" value="" style="endArrow=none;html=1;" edge="1" parent="1">
          <mxGeometry width="50" height="50" relative="1" as="geometry">
            <mxPoint x="860" y="370" as="sourcePoint" />
            <mxPoint x="860" y="140" as="targetPoint" />
          </mxGeometry>
        </mxCell>
        <mxCell id="cjXHX25kvEjNAGu8TwTu-55" value="" style="endArrow=classic;html=1;" edge="1" parent="1">
          <mxGeometry width="50" height="50" relative="1" as="geometry">
            <mxPoint x="860" y="370" as="sourcePoint" />
            <mxPoint x="860" y="140" as="targetPoint" />
          </mxGeometry>
        </mxCell>
        <mxCell id="cjXHX25kvEjNAGu8TwTu-56" value="" style="endArrow=classic;html=1;" edge="1" parent="1">
          <mxGeometry width="50" height="50" relative="1" as="geometry">
            <mxPoint x="860" y="140" as="sourcePoint" />
            <mxPoint x="780" y="140" as="targetPoint" />
          </mxGeometry>
        </mxCell>
        <mxCell id="cjXHX25kvEjNAGu8TwTu-58" value="" style="endArrow=classic;html=1;" edge="1" parent="1">
          <mxGeometry width="50" height="50" relative="1" as="geometry">
            <mxPoint x="680" y="140" as="sourcePoint" />
            <mxPoint x="640" y="140" as="targetPoint" />
          </mxGeometry>
        </mxCell>
        <mxCell id="cjXHX25kvEjNAGu8TwTu-59" value="" style="endArrow=classic;html=1;exitX=1;exitY=0.5;exitDx=0;exitDy=0;" edge="1" parent="1" source="cjXHX25kvEjNAGu8TwTu-46">
          <mxGeometry width="50" height="50" relative="1" as="geometry">
            <mxPoint x="870" y="610" as="sourcePoint" />
            <mxPoint x="860" y="425" as="targetPoint" />
          </mxGeometry>
        </mxCell>
        <mxCell id="cjXHX25kvEjNAGu8TwTu-60" value="" style="endArrow=classic;html=1;" edge="1" parent="1">
          <mxGeometry width="50" height="50" relative="1" as="geometry">
            <mxPoint x="860" y="430" as="sourcePoint" />
            <mxPoint x="860" y="370" as="targetPoint" />
          </mxGeometry>
        </mxCell>
      </root>
    </mxGraphModel>
  </diagram>
</mxfile>
