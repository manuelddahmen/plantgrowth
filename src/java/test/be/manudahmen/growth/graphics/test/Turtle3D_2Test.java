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
import be.manudahmen.growth.graphics.DrawingLSystem2D;
import be.manudahmen.growth.graphics.Turtle3D;
import be.manudahmen.growth.graphics.Turtle3D_1;
import be.manudahmen.growth.graphics.Turtle3D_3;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;

public class Turtle3D_2Test extends TestCaseExtended {

    @Override
    public void setUp() throws Exception {
        super.setUp();

    }

    public ZBuffer fct() {
        ZBuffer z = ZBufferFactory.instance(1600, 1200);
        z.backgroundTexture(new ColorTexture(new Color(90, 160, 50)));
        Turtle3D turtle3D;
        Camera camera = (new Camera(new Point3D(0, 0, -200), new Point3D(0, 0, 0)));
        z.camera(camera);
        turtle3D = new Turtle3D(z);

        turtle3D.line(100);
        turtle3D.rotationTete(Math.PI / 2);
        turtle3D.setColor(Color.BLACK);
        turtle3D.rotationLargeur(Math.PI / 2);
        turtle3D.line(100);
        turtle3D.rotationTete(Math.PI / 2);
        turtle3D.line(100);
        turtle3D.rotationTete(Math.PI / 2);
        turtle3D.line(100);
        return z;
    }

    public void testSquaresXYZaxis() {
        writeImage(fct());

    }

    public void testSquaresXYZaxis_3() {
        ZBuffer z = ZBufferFactory.instance(1600, 1200);
        ColorTexture colorTexture = new ColorTexture(new Color(140, 50, 100));
        z.backgroundTexture(colorTexture);
        z.camera(new Camera(new Point3D(0, 0, -200), new Point3D(0, 0, 0)));
        Turtle3D turtle3D = new Turtle3D(z);

        turtle3D.setzBuffer(z);


        turtle3D.setColor(Color.BLACK);
        turtle3D.line(100);
        turtle3D.rotationLargeur(Math.PI / 2);
        turtle3D.line(100);
        turtle3D.rotationLargeur(Math.PI / 2);
        turtle3D.line(100);
        turtle3D.rotationLargeur(Math.PI / 2);
        turtle3D.line(100);
        turtle3D.rotationLargeur(Math.PI / 2);


        writeImage(turtle3D.getzBuffer());

    }

}
