import org.strongback.components.Switch;
import org.strongback.components.ui.ContinuousRange;
import org.strongback.components.ui.DirectionalAxis;
import org.strongback.components.ui.InputDevice;

import java.util.HashMap;

/**
 * Created by tyler on 4/28/17.
 */
public class MockInput implements InputDevice {
    private HashMap<Integer,MockCRange> axes = new HashMap<>();
    private HashMap<Integer,Switch> buttons = new HashMap<>();
    private HashMap<Integer,DirectionalAxis> dpad = new HashMap<>();

    @Override
    public ContinuousRange getAxis(int axis) {
        if(axes.containsKey(axis))
            return axes.get(axis);
        return axes.put(axis,new MockCRange());
    }

    @Override
    public Switch getButton(int button) {
        if(buttons.containsKey(button))
            return buttons.get(button);
        return buttons.put(button,new MockSwitch());
    }

    @Override
    public DirectionalAxis getDPad(int pad) {
        if(dpad.containsKey(pad))
            return dpad.get(pad);
        return dpad.put(pad,new MockDPAD());
    }

}
