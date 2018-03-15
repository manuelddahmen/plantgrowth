/*
 * This file is part of Plants-Growth-2
 *     Plants-Growth-2 is free software: you can redistribute it and/or modify
 *     it under the terms of the GNU General Public License as published by
 *     the Free Software Foundation, either version 3 of the License, or
 *     (at your option) any later version.
 *
 *     Plants-Growth-2 is distributed in the hope that it will be useful,
 *     but WITHOUT ANY WARRANTY; without even the implied warranty of
 *     MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 *     GNU General Public License for more details.
 *
 *     You should have received a copy of the GNU General Public License
 *     along with Plants-Growth-2.  If not, see <http://www.gnu.org/licenses/>.
 */

/*
 * This file is part of Plants-Growth-2
 *     Plants-Growth-2 is free software: you can redistribute it and/or modify
 *     it under the terms of the GNU General Public License as published by
 *     the Free Software Foundation, either version 3 of the License, or
 *     (at your option) any later version.
 *
 *     Plants-Growth-2 is distributed in the hope that it will be useful,
 *     but WITHOUT ANY WARRANTY; without even the implied warranty of
 *     MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 *     GNU General Public License for more details.
 *
 *     You should have received a copy of the GNU General Public License
 *     along with Plants-Growth-2.  If not, see <http://www.gnu.org/licenses/>.
 */

/*
 * This file is part of Plants-Growth-2
 *     Plants-Growth-2 is free software: you can redistribute it and/or modify
 *     it under the terms of the GNU General Public License as published by
 *     the Free Software Foundation, either version 3 of the License, or
 *     (at your option) any later version.
 *
 *     Plants-Growth-2 is distributed in the hope that it will be useful,
 *     but WITHOUT ANY WARRANTY; without even the implied warranty of
 *     MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 *     GNU General Public License for more details.
 *
 *     You should have received a copy of the GNU General Public License
 *     along with Plants-Growth-2.  If not, see <http://www.gnu.org/licenses/>.
 */

/*
 * This file is part of Plants-Growth-2
 *     Plants-Growth-2 is free software: you can redistribute it and/or modify
 *     it under the terms of the GNU General Public License as published by
 *     the Free Software Foundation, either version 3 of the License, or
 *     (at your option) any later version.
 *
 *     Plants-Growth-2 is distributed in the hope that it will be useful,
 *     but WITHOUT ANY WARRANTY; without even the implied warranty of
 *     MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 *     GNU General Public License for more details.
 *
 *     You should have received a copy of the GNU General Public License
 *     along with Plants-Growth-2.  If not, see <http://www.gnu.org/licenses/>.
 */

package be.manudahmen.growth.graphics.test;

import be.manudahmen.empty3.*;
import be.manudahmen.growth.TestCaseExtended;
import be.manudahmen.growth.graphics.Turtle3D_4;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;

import static org.junit.Assert.*;

public class Turtle3D_4Test extends TestCaseExtended {
    @Override
    public void setUp() throws Exception {
        super.setUp();
    }

    public ZBuffer fct() {

        ZBuffer z = ZBufferFactory.instance(1600, 1200);

        z.backgroundTexture(new ColorTexture(new Color(90, 160, 50)));
        z.camera(new Camera(new Point3D(0, 0, -200), new Point3D(0, 0, 0)));
        z.suivante();
        z.scene(new Scene());
        z.scene().cameraActive(z.camera());
        Turtle3D_4 turtle3D_4;
        turtle3D_4 = new Turtle3D_4(z);
        turtle3D_4.setColor(Color.BLACK);
        turtle3D_4.rotL(Math.PI / 2);
        turtle3D_4.line(100);
        turtle3D_4.rotU(Math.PI / 2);
        turtle3D_4.rotU(Math.PI / 2);
        turtle3D_4.line(100);
        turtle3D_4.rotU(Math.PI / 2);
        turtle3D_4.line(100);
        turtle3D_4.rotU(Math.PI / 2);
        turtle3D_4.line(100);


        return z;
    }

    public void test1() {
        ZBuffer z = fct();
        writeImage(z);
    }

    public void writeImage(ZBuffer z) {
        z.draw();
        try {
            java.io.File imageFile = getUniqueFilenameForProduction("testResults", getClass().getCanonicalName() + "___test1", "jpg");
            ImageIO.write(z.image(), "jpg", imageFile);
            System.out.println(imageFile + " written");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}